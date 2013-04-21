package pl.edu.pk.olap.db;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * User: suowik
 * Date: 21.04.13
 * Time: 17:59
 */
public class ConnectionResolver {
    private static final String DATABASE = "jdbc:sqlserver://localhost:1433;DatabaseName=pk_olap";
    private static final String USERNAME = "suowik";
    private static final String PASSWORD = "zaq12wsx";

    public static Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            return DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
        } catch (Exception e) {
            Logger.getLogger(ConnectionResolver.class).error("cannot establish connection due to:", e);
            throw new Error("Cannot establish connection with database");
        }
    }
}
