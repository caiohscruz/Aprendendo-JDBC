/*

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ServerSQLConnection {

    public static void main (String[] args){

        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String connectionUrl = "jdbc:sqlserver://localhost;integratedSecurity=true;";

        try (Connection conn = DriverManager.getConnection(connectionUrl)){
            System.out.println("Sucesso");
        }
        catch (SQLException e) {
            System.out.println("Falha");
            e.printStackTrace();
        }
    }

}

 */