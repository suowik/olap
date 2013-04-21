package pl.edu.pk.olap.db.dao;

import org.apache.log4j.Logger;
import pl.edu.pk.olap.db.ConnectionResolver;
import pl.edu.pk.olap.db.dto.Computer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * User: suowik
 * Date: 21.04.13
 * Time: 18:08
 */
public class ComputerManager implements AccessManager<Computer> {

    private static final Logger LOGGER = Logger.getLogger(ComputerManager.class);
    private final static String INSERT = "INSERT INTO Computers(price,cpu,graphics,screen,hdd,model,os,ram) VALUES(?,?,?,?,?,?,?,?)";

    @Override
    public void insertAll(List<Computer> entities) {
        Connection connection = ConnectionResolver.getConnection();
        try {
            addAll(connection, entities);
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            gentlyClose(connection);
        }
    }

    private void addAll(Connection connection, List<Computer> entities) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT);
        for (Computer entity : entities) {
            insert(statement, entity);
        }
        connection.commit();
    }

    private void gentlyClose(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Computer entity) {
        Connection connection = ConnectionResolver.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            insert(statement,entity);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            gentlyClose(connection);
        }
    }

    private void insert(PreparedStatement statement, Computer entity) throws SQLException {
        statement.setInt(1,entity.getPrice());
        statement.setString(2,entity.getCpu());
        statement.setString(3,entity.getGraphics());
        statement.setString(4,entity.getScreen());
        statement.setString(5,entity.getHdd());
        statement.setString(6,entity.getModel());
        statement.setString(7,entity.getOs());
        statement.setString(8,entity.getRam());
        statement.execute();
    }
}
