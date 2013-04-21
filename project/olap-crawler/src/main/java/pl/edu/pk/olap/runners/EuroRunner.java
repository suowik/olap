package pl.edu.pk.olap.runners;

import pl.edu.pk.olap.crawlers.EuroNotebookCrawler;
import pl.edu.pk.olap.crawlers.controller.CrawlerController;

import java.util.Random;

/**
 * User: Paweł
 * Date: 09.03.13
 * Time: 18:10
 */
public class EuroRunner implements Runnable {
    @Override
    public void run() {
        CrawlerController crawlerController = new CrawlerController(40, "euro/"+new Random().nextInt(),100000, CrawlerController.ONE_SEC/5);
        crawlerController.crawl(EuroNotebookCrawler.class,EuroNotebookCrawler.LINKS);
    }
}
