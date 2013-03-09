package pl.edu.pk.olap.crawlers;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.regex.Pattern;

/**
 * User: suowik
 * Date: 09.03.13
 * Time: 15:56
 */
public abstract class AbstractNotebookCrawler extends WebCrawler {

    private final static Logger LOGGER = Logger.getLogger(AbstractNotebookCrawler.class);

    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|bmp|gif|jpe?g"
            + "|png|tiff?|mid|mp2|mp3|mp4|ico|gif"
            + "|wav|avi|mov|mpeg|ram|m4v|pdf"
            + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");

    @Override
    public boolean shouldVisit(WebURL webURL) {
        String url = webURL.getURL();
        return !FILTERS.matcher(url.toLowerCase()).matches() && url.toLowerCase().matches(getPageRegexp());
    }

    @Override
    public void visit(Page page) {
        if(page.getParseData() instanceof HtmlParseData){
            HtmlParseData html = (HtmlParseData) page.getParseData();
            LOGGER.info("NOTEBOOK: "+html.getTitle());
            parse(Jsoup.parse(html.getHtml()));
        }
    }

    protected abstract String getPageRegexp();
    protected abstract void parse(Document document);
}
