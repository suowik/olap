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
    @Override
    public void parse(Document document, Computer computer) {
        Elements techData = document.getElementsByClass("tech-data");
        for (Element table : techData) {
            Elements tBody = table.children();
            for (Element rows : tBody) {
                Elements cols = rows.children();
                for (Element col : cols) {
                    if(col.html().contains("Procesor")){
                        Elements tds = col.children();
                        //LOGGER.info(tds.get(1).html());
                    }
                }
            }
        }
    }
}
