package pl.edu.pk.olap.crawlers;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Date: 09.03.13
 * Time: 17:34
 */
public class MediaMarktNotebookCrawler extends AbstractNotebookCrawler {
    private static final Logger LOGGER = Logger.getLogger(MediaMarktNotebookCrawler.class);

    public static final String[] LINKS = new String[]{
            "http://www.mediamarkt.pl/komputery-i-tablety_laptopy-i-netbooki"
    };

    @Override
    protected String getPageRegexp() {
        return ".*notebook.*|.*ultrabook.*|.*netbook.*";
    }

    @Override
    protected void parse(Document document) {
        Elements techData = document.getElementsByClass("tech-data");
        for (Element table : techData) {
            Elements tBody = table.children();
            for (Element rows : tBody) {
                Elements cols = rows.children();
                for (Element col : cols) {
                    if(col.html().contains("Procesor")){
                        Elements tds = col.children();
                        LOGGER.info(tds.get(1).html());
                    }
                }
            }
        }
    }

}
