package pl.edu.pk.olap.runners;

import pl.edu.pk.olap.crawlers.KomputronikNotebookCrawler;
import pl.edu.pk.olap.crawlers.SaturnNotebookCrawler;
import pl.edu.pk.olap.crawlers.controller.CrawlerController;

/**
 * Created with IntelliJ IDEA.
 * User: Paweł
 * Date: 09.03.13
 * Time: 20:07
 * To change this template use File | Settings | File Templates.
 */
public class KomputronikRunner implements Runnable {
    @Override
    public void run() {
        CrawlerController crawlerController = new CrawlerController(40, "komputronik/",100000, CrawlerController.ONE_SEC);
        crawlerController.crawl(KomputronikNotebookCrawler.class, KomputronikNotebookCrawler.LINKS);
    }
}
