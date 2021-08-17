package AulaParte1;

import AulaParte1.ConnectionJDBC;

public class MySQLConnection {

    static String driver = "mysql";
    static String dbAdress = "localhost";
    static String dbName = "DigitalInnovationOne";
    static String user = "root";
    static String password = "";

    public static void main (String[] args){

        ConnectionJDBC MySQLConn = new ConnectionJDBC(driver, dbAdress, dbName, user, password);

        MySQLConn.testeConexao();
    }

}
