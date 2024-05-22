/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsi;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author M S I
 */
public class Connector {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/perpustakaan";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    PreparedStatement prepare;

    public Connector() {
        try {
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Connection failed");
        }
    }
}
