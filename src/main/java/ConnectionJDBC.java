import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    String driver;
    String dbAdress;
    String dbName;
    String user;
    static String password;

    public ConnectionJDBC(String driver, String dbAdress, String dbName, String user, String password) {
        this.driver = driver;
        this.dbAdress = dbAdress;
        this.dbName = dbName;
        this.user = user;
        this.password = password;
    }

    public void testeConexao(){


        StringBuilder sb = new StringBuilder("jdbc:")
                .append(this.driver).append("://")
                .append(this.dbAdress).append("/")
                .append(this.dbName);

        String urlConnection = sb.toString();
        try (Connection conn = DriverManager.getConnection(urlConnection, this.user, password)){
            System.out.println("Sucesso");
        }
        catch (SQLException e){
            System.out.println("Falha");
            e.printStackTrace();
        }

    }
}
