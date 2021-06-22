package com;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author 沉睡的芭芭拉
 */
public class JdbcUtils {
    private static final String DBCONFIG = "com/config.properties";
    private static Properties prop = new Properties();
    static {
        try {
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(DBCONFIG);
            prop.load(in);
            try {
                Class.forName(prop.getProperty("driverClassName"));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch(IOException e) {
    }
 }
  public static Connection getConnection() {
        try {
            return DriverManager.getConnection(prop.getProperty("url"),
                    prop.getProperty("username"), prop.getProperty("password"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
