package DAO;

import conexion.Conexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO implements LibroDAO {

    // Métodos CRUD

    public void createLibro(Libro libro) throws IOException {
        try {
            Connection conexion = Conexion.conectar();
            String consultaSQL = "INSERT INTO gbp_almacen.gbp_alm_cat_libros (titulo, autor, isbn, edicion) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL);
            preparedStatement.setString(1, libro.getTitulo());
            preparedStatement.setString(2, libro.getAutor());
            preparedStatement.setString(3, libro.getIsbn());
            preparedStatement.setInt(4, libro.getEdicion());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Libro> readLibros() throws IOException {
        List<Libro> libros = new ArrayList<>();

        try {
            Connection conexion = Conexion.conectar();
            String consultaSQL = "SELECT * FROM gbp_almacen.gbp_alm_cat_libros";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(consultaSQL);

            while (resultSet.next()) {
                Libro libro = new Libro(
                    resultSet.getString("titulo"),
                    resultSet.getString("autor"),
                    resultSet.getString("isbn"),
                    resultSet.getInt("edicion")
                );
                libros.add(libro);
            }

            resultSet.close();
            statement.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return libros;
    }

    public void updateLibro(Libro libro) throws IOException {
        try {
            Connection conexion = Conexion.conectar();
            String consultaSQL = "UPDATE gbp_almacen.gbp_alm_cat_libros SET titulo=?, autor=?, edicion=? WHERE isbn=?";
            PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL);
            preparedStatement.setString(1, libro.getTitulo());
            preparedStatement.setString(2, libro.getAutor());
            preparedStatement.setInt(3, libro.getEdicion());
            preparedStatement.setString(4, libro.getIsbn());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteLibro(String isbn) throws IOException {
        try {
            Connection conexion = Conexion.conectar();
            String consultaSQL = "DELETE FROM gbp_almacen.gbp_alm_cat_libros WHERE isbn=?";
            PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL);
            preparedStatement.setString(1, isbn);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
