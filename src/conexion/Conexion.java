/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

/**
 *
 * @author Puesto19
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {

    public static Connection conectar() throws FileNotFoundException, IOException, SQLException {
        Properties properties = new Properties();
        Connection connection = null;

        try {
            properties.load(new FileInputStream(new File("bbdd.properties")));

            String url = properties.getProperty("URL");
            String user = properties.getProperty("USUARIO");
            String password = properties.getProperty("CLAVE");

            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Conexion establecida.");
            } else {
                System.out.println("No se pudo establecer la conexion.");
            }
        } catch (IOException | SQLException e) {
            throw e; 
        }
        return connection;
    }

}
