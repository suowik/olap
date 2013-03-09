package pl.edu.pk.olap;

import pl.edu.pk.olap.runners.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(new EuroRunner());
        executor.execute(new VobisRunner());
        executor.execute(new MediaMarktRunner());
        executor.execute(new SaturnRunner());
        executor.execute(new XKomRunner());
        executor.shutdown();
        while (!executor.isTerminated());
        System.out.println("DONE");

        /*
        CrawlerController crawlerController = new CrawlerController(40, 100000, CrawlerController.ONE_SEC/5);
        //crawlerController.crawl(VobisNotebookCrawler.class, VobisNotebookCrawler.LINKS );
        //crawlerController.crawl(XKomNotebookCrawler.class, XKomNotebookCrawler.LINKS);
        //crawlerController.crawl(SaturnNotebookCrawler.class, SaturnNotebookCrawler.LINKS);
        //crawlerController.crawl(MediaMarktNotebookCrawler.class, MediaMarktNotebookCrawler.LINKS);
        crawlerController.crawl(EuroNotebookCrawler.class, EuroNotebookCrawler.LINKS);
        */
    }
}
