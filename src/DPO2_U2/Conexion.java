package DPO2_U2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
    String db = "DataAdminl";
    String url = "jbdc:mysql://rpimate.local:3306/";
    String user ="root";
    String passwd = "";
    String driver = "com.mysql.cj.jdbc.driver";
    Connection conn;
    
    public Conexion(){

    }

    public Connection conectar(){
        try {
            Class.forName(driver);
            conn =DriverManager.getConnection(url+db, user, passwd);
            //JOptionPane.showMessageDialog(null, "Conectado a " + db, "Estado", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Conectado a " +db);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            //JOptionPane.showMessageDialog(null, "No conectado", "Estado", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Conección fallida");
            e.printStackTrace();
        }
        return conn;
    }

    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
