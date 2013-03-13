package pl.edu.pk.olap.quartz;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import pl.edu.pk.olap.context.ParsingContext;
import pl.edu.pk.olap.runners.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: Paweł
 * Date: 10.03.13
 * Time: 12:14
 */
public class CrawlingJob implements Job {
    private static final Logger LOGGER = Logger.getLogger(CrawlingJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOGGER.info("START");
        ParsingContext context = new ParsingContext();
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.execute(new MediaMarktRunner());
        executor.execute(new SaturnRunner());
        executor.execute(new KomputronikRunner());
        executor.execute(new EuroRunner());
        executor.execute(new VobisRunner());
        //executor.execute(new XKomRunner());
        executor.shutdown();
        while (!executor.isTerminated()) ;
        context.clear();
        LOGGER.info("END");
    }
}
