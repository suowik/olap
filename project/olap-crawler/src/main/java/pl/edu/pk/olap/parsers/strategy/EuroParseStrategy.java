package pl.edu.pk.olap.parsers.strategy;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pl.edu.pk.olap.db.dto.Computer;

/**
 * User: suowik
 * Date: 13.03.13
 * Time: 14:32
 */
public class EuroParseStrategy implements ParseStrategy {
    private static final Logger LOGGER = Logger.getLogger(EuroParseStrategy.class);

    @Override
    public void parse(Document document, Computer computer) {
        computer.setPrice(parsePrice(document));
        computer.setModel(parseModel(document));
        computer.setSource(Computer.Source.EURO_RTV_AGD);
        Elements rows = document.getElementById("basic_tech_details").getElementsByTag("tr");
        for (Element tr : rows) {
            if (ParseUtils.contains(tr, "Procesor")) {
                computer.setCpu(ParseUtils.extractValue(tr));
            }
            if (ParseUtils.contains(tr, "System operacyjny")) {
                computer.setOs(ParseUtils.extractValue(tr));
            }
            if (ParseUtils.contains(tr, "Pamięć RAM")) {
                computer.setRam(ParseUtils.extractValue(tr));
            }
            if (ParseUtils.contains(tr, "Dysk twardy")) {
                computer.setHdd(ParseUtils.extractValue(tr));
            }
            if (ParseUtils.contains(tr, "Ekran") && !ParseUtils.contains(tr, "Ekran dotykowy")) {
                computer.setScreen(ParseUtils.extractValue(tr));
            }
            if (ParseUtils.contains(tr, "Grafika")) {
                computer.setGraphics(ParseUtils.extractValue(tr));
            }
        }
    }

    private String parseModel(Document document) {
        return document.getElementById("tab-opis").child(1).getElementsByClass("opis-podstawowy").get(0).child(1).text().toUpperCase().replaceAll(ParseUtils.REDUNDANT_PATTERN, "");
    }

    private int parsePrice(Document document) {
        return Integer.parseInt(document.getElementsByClass("prices").get(0).getElementsByClass("cred").get(0).html().replaceAll(ParseUtils.PRICE_OMIT, ""));
    }
}
