package pl.edu.pk.olap.db.dao;

import pl.edu.pk.olap.db.dto.Computer;

/**
 * User: suowik
 * Date: 21.04.13
 * Time: 18:23
 */
public class ComputerManagerFactory {

    private ComputerManagerFactory(){}

    public static AccessManager<Computer> create(){
        return new ComputerManager();
    }
}
