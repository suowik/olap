package pl.edu.pk.olap.crawlers;

import pl.edu.pk.olap.parsers.strategy.ParseStrategy;

/**
 * User: Paweł
 * Date: 09.03.13
 * Time: 17:54
 */
public class EuroNotebookCrawler extends AbstractNotebookCrawler {
    public static final String[] LINKS = new String[]{
            "http://www.euro.com.pl/laptopy-i-netbooki.bhtml"
    };

    @Override
    protected String getPageRegexp() {
        return ".*/laptopy-i-netbooki/.*";
    }

    @Override
    protected ParseStrategy getStrategy() {
        return null;
    }

}
