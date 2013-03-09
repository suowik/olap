package pl.edu.pk.olap;

import pl.edu.pk.olap.runners.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        //executor.execute(new KomputronikRunner());
        //executor.execute(new EuroRunner());
        //executor.execute(new VobisRunner());
        executor.execute(new MediaMarktRunner());
        //executor.execute(new SaturnRunner());
        //executor.execute(new XKomRunner());
        executor.shutdown();
        while (!executor.isTerminated());
        System.out.println("DONE");
    }
}
