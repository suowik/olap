package pl.edu.pk.olap.runners;

import pl.edu.pk.olap.crawlers.XKomNotebookCrawler;
import pl.edu.pk.olap.crawlers.controller.CrawlerController;

/**
 * Date: 09.03.13
 * Time: 18:00
 */
public class XKomRunner implements Runnable {
    @Override
    public void run() {
        CrawlerController crawlerController = new CrawlerController(1,"xkom/",100000,CrawlerController.ONE_SEC);
        crawlerController.crawl(XKomNotebookCrawler.class,XKomNotebookCrawler.LINKS);
    }
}
