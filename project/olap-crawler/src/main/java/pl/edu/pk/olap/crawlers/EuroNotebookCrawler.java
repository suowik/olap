package pl.edu.pk.olap.crawlers;

/**
 * Created with IntelliJ IDEA.
 * User: Paweł
 * Date: 09.03.13
 * Time: 17:54
 * To change this template use File | Settings | File Templates.
 */
public class EuroNotebookCrawler extends AbstractNotebookCrawler {
    public static final String[] LINKS = new String[]{
            "http://www.euro.com.pl/laptopy-i-netbooki.bhtml"
    };

    @Override
    protected String getPageRegexp() {
        return ".*/laptopy-i-netbooki/.*";
    }
}
