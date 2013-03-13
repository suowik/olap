package pl.edu.pk.olap.parsers.strategy;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pl.edu.pk.olap.dto.Computer;
import pl.edu.pk.olap.utils.StringUtils;


/**
 * User: suowik
 * Date: 13.03.13
 * Time: 12:28
 */
public class VobisParseStrategy implements ParseStrategy {
    private static final Logger LOGGER = Logger.getLogger(VobisParseStrategy.class);
    @Override
    public void parse(Document document, Computer computer) {
        computer.setPrice(parsePrice(document));
        computer.setModel(parseModel(document));
        Elements trs = document.getElementById("tab-02").getElementsByTag("table").get(0).getElementsByTag("tbody").get(0).getElementsByTag("tr");
        for (Element tr : trs) {
            if(ParseUtils.contains(tr,"System operacyjny")){
                computer.setOs(ParseUtils.extractValue(tr));
            }
            if(ParseUtils.contains(tr,"Pojemność dysku")){
                computer.setHdd(ParseUtils.extractValue(tr));
            }
            if(ParseUtils.contains(tr,"Przekątna ekranu")){
                computer.setScreen(ParseUtils.extractValue(tr));
            }
            if(ParseUtils.contains(tr,"Model karty graficznej")){
                computer.setGraphics(ParseUtils.extractValue(tr));
            }
            if(ParseUtils.contains(tr,"Pojemność pamięci RAM")){
                computer.setRam(ParseUtils.extractValue(tr));
            }
            if(ParseUtils.contains(tr,"Producent procesora")){
                computer.setCpu(parseCPU(tr));
            }
        }
    }

    private String parseCPU(Element tr) {
        Element model = tr.nextElementSibling();
        Element clock = model.nextElementSibling();
        return ParseUtils.extractValue(tr)+" "+ParseUtils.extractValue(model)+" "+ParseUtils.extractValue(clock);
    }

    private String parseModel(Document document) {
        return document.getElementsByClass("main-data").get(0).child(1).text().toUpperCase().replaceAll(ParseUtils.REDUNDANT_PATTERN, "");
    }

    private int parsePrice(Document document) {
        String pattern = "["+ StringUtils.POLISH_LETTERS+"A-Za-z &;<>/]";
        return Integer.parseInt(document.getElementsByClass("current-price").get(0).html().replaceAll(pattern, ""));
    }
}
