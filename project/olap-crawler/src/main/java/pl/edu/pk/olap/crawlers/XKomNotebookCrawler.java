package pl.edu.pk.olap.crawlers;

import pl.edu.pk.olap.parsers.strategy.ParseStrategy;
import pl.edu.pk.olap.parsers.strategy.XKomParseStrategy;

/**
 * User: Paweł
 * Date: 09.03.13
 * Time: 17:13
 */
public class XKomNotebookCrawler extends AbstractNotebookCrawler {

    public static final String[] LINKS = new String[]{"http://www.x-kom.pl/g-2/c/159-laptopy-notebooki-ultrabooki.html"};

    @Override
    protected String getPageRegexp() {
        return ".*-notebook-.*|.*-netbook-.*|.*-ultrabook-.*";
    }

    @Override
    protected ParseStrategy getStrategy() {
        return new XKomParseStrategy();
    }

}
