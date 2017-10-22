package org.simpleemployees.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Copyright (c) 2017-2018 all right reserved !
 * This was created by Extends for CorePlugin
 *
 * @author Extends on 22/10/2017
 * @version 1.0.0
 */

public class Database {

    public String host, database, user, password;
    public int port;
    public Connection connection;

    public void openConnection() {
        try {
            if ((connection != null) && (!connection.isClosed())) {
                return;
            }
            synchronized (this) {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql;//" + this.host + ":" + this.port + "/" + database + "?autoReconnect=true" + this.user + this.password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void removeConnection() {
        try {
            if ((connection == null) && (connection.isClosed())) {
                return;
            }
            synchronized (this) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }
}
