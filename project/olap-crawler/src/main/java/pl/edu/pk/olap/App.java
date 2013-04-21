package pl.edu.pk.olap;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import pl.edu.pk.olap.quartz.CrawlingJob;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            JobDetail job = JobBuilder.newJob(CrawlingJob.class).withIdentity("CrawlingJob","group1").build();
            Trigger crawlingTrigger = TriggerBuilder.newTrigger()
                                            .startNow()
                                            .withIdentity("CrawlingTrigger","group1")
                                            .withSchedule(SimpleScheduleBuilder
                                                            .simpleSchedule()
                                                            .withIntervalInHours(2).withRepeatCount(1))
                                            .build();
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(job, crawlingTrigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        System.out.println("DONE");
    }
}
