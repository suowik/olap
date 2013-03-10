package pl.edu.pk.olap.crawlers;

import pl.edu.pk.olap.parsers.strategy.ParseStrategy;

/**
 * User: Paweł
 * Date: 09.03.13
 * Time: 20:06
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
    protected ParseStrategy getStrategy() {
        return null;
    }


}
