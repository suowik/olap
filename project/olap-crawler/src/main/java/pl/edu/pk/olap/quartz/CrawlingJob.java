package pl.edu.pk.olap.quartz;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import pl.edu.pk.olap.runners.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: Paweł
 * Date: 10.03.13
 * Time: 12:14
 * To change this template use File | Settings | File Templates.
 */
public class CrawlingJob implements Job {
    private static final Logger LOGGER = Logger.getLogger(CrawlingJob.class);
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOGGER.info("START");
        ExecutorService executor = Executors.newFixedThreadPool(6);
        executor.execute(new KomputronikRunner());
        executor.execute(new EuroRunner());
        executor.execute(new VobisRunner());
        executor.execute(new MediaMarktRunner());
        executor.execute(new SaturnRunner());
        executor.execute(new XKomRunner());
        executor.shutdown();
        while (!executor.isTerminated());
        LOGGER.info("END");
    }
}
