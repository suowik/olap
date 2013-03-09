package pl.edu.pk.olap.crawlers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created with IntelliJ IDEA.
 * User: Paweł
 * Date: 09.03.13
 * Time: 20:06
 * To change this template use File | Settings | File Templates.
 */
public class KomputronikNotebookCrawler extends AbstractNotebookCrawler {

    public static final String[] LINKS = new String[]{
            "http://www.komputronik.pl/category/5022/Komputery-Laptopy_i_netbooki.html"
    };

    @Override
    protected String getPageRegexp() {
        return ".*Laptopy_i_netbooki.*".toLowerCase();
    }

    @Override
    protected void parse(Document document) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

}
