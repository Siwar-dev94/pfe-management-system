/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Connexion {
     private static final String URL =
        "jdbc:mysql://localhost:3306/gestion_pfe";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connexion MySQL réussie ✅");
            } catch (ClassNotFoundException e) {
                System.out.println("Driver MySQL introuvable ❌");
            } catch (SQLException e) {
                System.out.println("Erreur de connexion ❌");
                
            }
        }
        return connection;
    }
}
