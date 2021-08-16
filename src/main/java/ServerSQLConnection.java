import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* Não está funcionando ainda, pretendo implementar a conexao com o SQLServer

public class ServerSQLConnection {

    public static void main (String[] args){

        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=DigitalInnovationOne;integratedSecurity=true;";

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