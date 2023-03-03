package Bean;

import Bean.Products;

import java.sql.Connection;
import java.sql.DriverManager;

public  class Connectionclass {
    public  Connection connection() throws Exception {



        String url = "jdbc:mysql://localhost:3306/ecommerse";
        String password = "12345678910";
        String username = "root";
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }
}
