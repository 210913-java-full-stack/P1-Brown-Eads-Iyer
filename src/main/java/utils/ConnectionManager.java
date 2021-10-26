package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * a now useless class used to connect to the database using connection.properties
 * @author James Brown
 */
public class ConnectionManager {
    private static Connection c;
    private static FileLogger fl;

    private ConnectionManager(){}

    /**
     * Static method that returns a connection (Singleton)
     */
    public static Connection getConnection(){
        fl = FileLogger.getFileLogger();
        if (c == null){
            try {
                Properties props = new Properties();
                ClassLoader cl = Thread.currentThread().getContextClassLoader();
                InputStream file = cl.getResourceAsStream("connections.properties");
                props.load(file);
                Class.forName("org.mariadb.jdbc.Driver");

                String cString = "jdbc:mariadb://" +
                        props.getProperty("hostname") + ":" +
                        props.getProperty("port") + "/" +
                        props.getProperty("databaseName") + "?user=" +
                        props.getProperty("user") + "&password=" +
                        props.getProperty("password");

                System.out.println("Connected to data source!");
                c = DriverManager.getConnection(cString);
            } catch(SQLException | IOException | ClassNotFoundException e){
                fl.writeLog(e.getMessage(), 0);
            }
        }
        return c;
    }
}
