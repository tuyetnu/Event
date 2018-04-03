/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuntt.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;

public class MyConnection implements Serializable {
    public static Connection getMyConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://NUNTTSE62525:1433; databaseName = EventDB;" + "user = sa; password = 1805");
        return conn;
    }
    
}
