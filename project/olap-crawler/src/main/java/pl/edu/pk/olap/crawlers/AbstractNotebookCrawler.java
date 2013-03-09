package pl.edu.pk.olap.crawlers;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.apache.log4j.Logger;

/**
 * User: suowik
 * Date: 09.03.13
 * Time: 15:56
 */
public abstract class AbstractNotebookCrawler extends WebCrawler {

    private final static Logger LOGGER = Logger.getLogger(AbstractNotebookCrawler.class);

    @Override
    public boolean shouldVisit(WebURL url) {
        return url.getURL().toLowerCase().matches(getPageRegexp());
    }

    @Override
    public void visit(Page page) {
        if(page.getParseData() instanceof HtmlParseData){
            HtmlParseData html = (HtmlParseData) page.getParseData();
            LOGGER.info("NOTEBOOK: "+html.getTitle());
        }
    }

    protected abstract String getPageRegexp();

}
