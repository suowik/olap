package pl.edu.pk.olap.parsers.strategy;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pl.edu.pk.olap.db.dto.Computer;

/**
 * User: suowik
 * Date: 13.03.13
 * Time: 13:53
 */
public class KomputronikParseStrategy implements ParseStrategy {

    private static final Logger LOGGER = Logger.getLogger(KomputronikParseStrategy.class);

    @Override
    public void parse(Document document, Computer computer) {
        computer.setPrice(parsePrice(document));
        computer.setModel(parseModel(document));
        Elements trs = document.getElementsByClass("specification").get(0).getElementsByTag("tr");
        for (Element tr : trs) {
            if(ParseUtils.contains(tr,"zainstalowany system operacyjny")){
                computer.setOs(extractValue(tr));
            }
            if(ParseUtils.contains(tr,"pojemność dysku twardego")){
                computer.setHdd(extractValue(tr));
            }
            if(ParseUtils.contains(tr,"przekątna ekranu")){
                computer.setScreen(extractValue(tr));
            }
            if(ParseUtils.contains(tr,"karta graficzna")){
                computer.setGraphics(extractValue(tr));
            }
            if(ParseUtils.contains(tr,"wielkość pamięci RAM")){
                computer.setRam(extractValue(tr));
            }
            if(ParseUtils.contains(tr,"procesor")){
                computer.setCpu(extractValue(tr));
            }
        }
    }

    private static String extractValue(Element tr) {
        return tr.child(1).getElementsByTag("li").get(0).text();
    }

    private int parsePrice(Document document) {
        String price;
        try {
            price = document.getElementsByClass("retailPrice").get(0).child(1).html().replaceAll(ParseUtils.PRICE_OMIT, "").trim();
        }catch (Exception e){
            try {
                price = document.getElementsByClass("internetPrice").get(0).child(1).html().replaceAll(ParseUtils.PRICE_OMIT, "").trim();
            } catch (Exception e1){
                price = "";
            }
        }
        price = price.replaceAll(",",".");
        try {
            return ((Double)Double.parseDouble(price)).intValue();
        } catch (NumberFormatException e){
            return 0;
        }
    }

    private String parseModel(Document document) {
        return document.getElementsByClass("product").get(0).getElementsByClass("name").get(0).text().toUpperCase().replaceAll(ParseUtils.REDUNDANT_PATTERN,"");
    }
}
