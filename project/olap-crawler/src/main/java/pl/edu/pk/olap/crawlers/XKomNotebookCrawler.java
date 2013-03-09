package pl.edu.pk.olap.crawlers;

/**
 * Created with IntelliJ IDEA.
 * User: Paweł
 * Date: 09.03.13
 * Time: 17:13
 * To change this template use File | Settings | File Templates.
 */
public class XKomNotebookCrawler extends AbstractNotebookCrawler {

    public static final String[] LINKS = new String[]{"http://www.x-kom.pl/g-2/c/159-laptopy-notebooki-ultrabooki.html"};

    @Override
    protected String getPageRegexp() {
        return ".*-notebook-.*|.*-netbook-.*|.*-ultrabook-.*";
    }
}
