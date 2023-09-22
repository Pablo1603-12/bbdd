package Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Puesto19
 */
import java.sql.Connection;
import conexion.Conexion;
import java.sql.Statement;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

    public static void main(String[] args) throws IOException {
        Test test = new Test();
        test.consultaBiblioteca();

    }

    public void consultaBiblioteca() throws IOException {
        String consultaSQL = "SELECT * FROM gbp_almacen.gbp_alm_cat_libros";

        try {
            Connection conexion = Conexion.conectar();
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(consultaSQL);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("titulo") + " | "
                        + resultSet.getString("autor") + " | "
                        + resultSet.getString("isbn") + " | "
                        + resultSet.getString("edicion"));
            }

            resultSet.close();
            statement.close();
            conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
