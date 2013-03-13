package pl.edu.pk.olap.parsers.strategy;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pl.edu.pk.olap.dto.Computer;

/**
 * User: Paweł
 * Date: 10.03.13
 * Time: 15:34
 */
public class MediaMarktParseStrategy implements ParseStrategy {

    private static final String TABLE_NAME = "tech-data";

    @Override
    public void parse(Document document, Computer computer) {
        computer.setPrice(PriceExtractor.parse(document));
        computer.setModel(extractModel(document));
        Elements techData = document.getElementsByClass(TABLE_NAME);
        for (Element table : techData) {
            Elements tBody = table.children();
            for (Element rows : tBody) {
                Elements cols = rows.children();
                for (Element col : cols) {
                    if(ParseUtils.contains(col, "Procesor")){
                        computer.setCpu(ParseUtils.extractValue(col));
                    }
                    if(ParseUtils.contains(col, "System operacyjny")){
                        computer.setOs(ParseUtils.extractValue(col));
                    }
                    if(ParseUtils.contains(col, "Pamięć RAM (zainstalowana)")){
                        computer.setRam(ParseUtils.extractValue(col));
                    }
                    if(ParseUtils.contains(col, "Dysk HDD") || ParseUtils.contains(col, "Dysk SSD")){
                        computer.setHdd(ParseUtils.extractValue(col));
                    }
                    if(ParseUtils.contains(col, "Przekątna ekranu [cal]")){
                        computer.setScreen(ParseUtils.extractValue(col));
                    }
                    if(ParseUtils.contains(col, "Karta graficzna")){
                        computer.setGraphics(ParseUtils.extractValue(col));
                    }
                }
            }
        }
    }

    private String extractModel(Document document) {
        return document.getElementsByClass("prd-name").html().toUpperCase().replaceAll(ParseUtils.REDUNDANT_PATTERN, "").trim();
    }


}
