package pl.edu.pk.olap.crawlers;

/**
 * Date: 09.03.13
 * Time: 17:34
 */
public class SaturnNotebookCrawler extends AbstractNotebookCrawler {
    public static final String[] LINKS = new String[]{
            "http://www.saturn.pl/komputery-i-tablety_laptopy-i-netbooki"
    };

    @Override
    protected String getPageRegexp() {
        return ".*notebook.*|.*ultrabook.*|.*netbook.*";
    }
}
