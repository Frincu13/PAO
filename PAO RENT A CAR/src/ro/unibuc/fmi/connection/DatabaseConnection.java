package ro.unibuc.fmi.connection;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;

public class DatabaseConnection {

    private static DatabaseConnection instance;

    private final String url = "jdbc:mysql://localhost:3306/rent?serverTimezone=UTC";
    private final String username = "root";
    private final String password = "frincu";

    private Connection connection;

    private DatabaseConnection() {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
            /*Statement mystmt = this.connection.createStatement();
            String sql = "select * from customer";
            ResultSet rs = mystmt.executeQuery(sql);
            while (rs.next())
                System.out.println(rs.getString("nume"));*/
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();


        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}