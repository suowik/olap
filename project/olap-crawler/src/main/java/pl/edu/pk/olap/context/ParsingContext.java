package pl.edu.pk.olap.context;

import pl.edu.pk.olap.dto.Computer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: Paweł
 * Date: 10.03.13
 * Time: 14:53
 */
public class ParsingContext {
    private static List<Computer> computers;

    public ParsingContext() {
        computers = Collections.synchronizedList(new ArrayList<Computer>());
    }

    public static void add(Computer computer){
        computers.add(computer);
    }

    public static List<Computer> getAll(){
        return computers;
    }

    public void clear() {
        computers.clear();
    }
}
