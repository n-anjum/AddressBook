package net.therap.addressbook.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: sazzadur
 * @since: 10/3/12 12:41 PM
 */
public class DatabaseConnectionPool {

    private static DataSource dataSource;
    private static final String DRIVER_NAME;
    private static final String URL;
    private static final String UNAME;
    private static final String PWD;
    public static ComboPooledDataSource comboPooledDataSource;
    /*private static final Logger log = LoggerFactory.getLogger(DatabaseConnectionPool.class);*/


    static {

        final ResourceBundle config = ResourceBundle.getBundle("db");
        DRIVER_NAME = config.getString("jdbc.driver");
        URL = config.getString("jdbc.url.address");
        UNAME = config.getString("db.user");
        PWD = config.getString("db.password");

        try {
            dataSource = setupDataSource();
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    private static DataSource setupDataSource() throws PropertyVetoException {

        comboPooledDataSource = new ComboPooledDataSource();

        comboPooledDataSource.setDriverClass(DRIVER_NAME);
        comboPooledDataSource.setJdbcUrl(URL);
        comboPooledDataSource.setUser(UNAME);
        comboPooledDataSource.setPassword(PWD);

        comboPooledDataSource.setMinPoolSize(5);
        comboPooledDataSource.setAcquireIncrement(5);
        comboPooledDataSource.setMaxPoolSize(20);
        return comboPooledDataSource;
    }

}

