package pl.edu.pk.olap.crawlers.controller;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.apache.log4j.Logger;

/**
 * User: suowik
 * Date: 09.03.13
 * Time: 15:54
 */
public class CrawlerController {
    public static final int ONE_SEC = 1000;
    public static final String DEFAULT_STORAGE = "data/crawl/root";
    private final static Logger LOGGER = Logger.getLogger(CrawlerController.class);
    private int numberOfCrawlers;
    private CrawlController controller;

    public CrawlerController(int numberOfCrawlers, int pagesToFetch) {
        this(numberOfCrawlers, DEFAULT_STORAGE, pagesToFetch, ONE_SEC);
    }

    public CrawlerController(int numberOfCrawlers, int pagesToFetch, int delay) {
        this(numberOfCrawlers, DEFAULT_STORAGE, pagesToFetch, delay);
    }

    public CrawlerController(int numberOfCrawlers, String storageFolder, int pagesToFetch, int delay) {
        this.numberOfCrawlers = numberOfCrawlers;
        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(storageFolder);
        config.setMaxDepthOfCrawling(3);
        config.setPolitenessDelay(delay);
        config.setResumableCrawling(false);
        config.setMaxPagesToFetch(pagesToFetch);
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        try {
            controller = new CrawlController(config, pageFetcher, robotstxtServer);
        } catch (Exception e) {
            LOGGER.fatal("failed to initialise crawlers controller due to: ", e);
            throw new Error("Failed to initialise crawlers controller");
        }

    }

    public void crawl(Class crawler, String... seeds) {
        for (String seed : seeds) {
            controller.addSeed(seed);
        }
        controller.start(crawler, numberOfCrawlers);
    }

}
