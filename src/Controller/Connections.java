package Controller;

import java.sql.Connection;
import java.sql.DriverManager;


public class Connections {
    private String url ;
    private String user ;
    private String pass ;


    public Connections(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public Connection getConnections() {
        Connection con =null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(
                    this.url, this.user, this.pass);
            System.out.println("CONNECTED : " + url );
        }catch (Exception e){
            System.err.println(e);
        }
        return con;
    }

}
