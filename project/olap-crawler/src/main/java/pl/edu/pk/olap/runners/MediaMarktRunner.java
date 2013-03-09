package pl.edu.pk.olap.runners;

import pl.edu.pk.olap.crawlers.MediaMarktNotebookCrawler;
import pl.edu.pk.olap.crawlers.controller.CrawlerController;

/**
 * Created with IntelliJ IDEA.
 * User: Paweł
 * Date: 09.03.13
 * Time: 18:11
 * To change this template use File | Settings | File Templates.
 */
public class MediaMarktRunner implements Runnable {
    @Override
    public void run() {
        CrawlerController crawlerController = new CrawlerController(40, "mm/",100000, CrawlerController.ONE_SEC/5);
        crawlerController.crawl(MediaMarktNotebookCrawler.class,MediaMarktNotebookCrawler.LINKS);
    }
}
