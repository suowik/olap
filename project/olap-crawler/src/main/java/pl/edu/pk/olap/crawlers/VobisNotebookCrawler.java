package pl.edu.pk.olap.crawlers;

import pl.edu.pk.olap.parsers.strategy.ParseStrategy;
import pl.edu.pk.olap.parsers.strategy.VobisParseStrategy;

/**
 * User: Paweł
 * Date: 09.03.13
 * Time: 16:50
 */
public class VobisNotebookCrawler extends AbstractNotebookCrawler {
    public final static String[] LINKS = new String[]{
            "http://www.vobis.pl/notebooki-i-tablety/notebooki-3-787.html?str=1",
            "http://www.vobis.pl/notebooki-i-tablety/notebooki-3-787.html?str=2",
            "http://www.vobis.pl/notebooki-i-tablety/notebooki-3-787.html?str=3",
            "http://www.vobis.pl/notebooki-i-tablety/notebooki-3-787.html?str=4",
            "http://www.vobis.pl/notebooki-i-tablety/notebooki-3-787.html?str=5",
            "http://www.vobis.pl/notebooki-i-tablety/notebooki-3-787.html?str=6",
            "http://www.vobis.pl/notebooki-i-tablety/notebooki-3-787.html?str=7",
            "http://www.vobis.pl/notebooki-i-tablety/notebooki-3-787.html?str=8",
            "http://www.vobis.pl/notebooki-i-tablety/notebooki-3-787.html?str=9",
            "http://www.vobis.pl/notebooki-i-tablety/notebooki/ultrabooki-3-825.html?str=1",
            "http://www.vobis.pl/notebooki-i-tablety/notebooki/ultrabooki-3-825.html?str=2",
            "http://www.vobis.pl/notebooki-i-tablety/notebooki/ultrawydajne-3-823.html?str=1",
            "http://www.vobis.pl/notebooki-i-tablety/notebooki/ultrawydajne-3-823.html?str=2",
            "http://www.vobis.pl/notebooki-i-tablety/notebooki/ultrawydajne-3-823.html?str=3",
            "http://www.vobis.pl/notebooki-i-tablety/notebooki/ultrawydajne-3-823.html?str=4",
            "http://www.vobis.pl/notebooki-i-tablety/notebooki/mobilne-3-824.html?str=1",
            "http://www.vobis.pl/notebooki-i-tablety/notebooki/mobilne-3-824.html?str=2"};

    @Override
    protected String getPageRegexp() {
        return ".*notebook-.*|.*netbook-.*|.*ultrabook-.*";
    }

    @Override
    protected ParseStrategy getStrategy() {
        return new VobisParseStrategy();
    }

}
