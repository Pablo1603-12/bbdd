/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Puesto19
 */
import modelo.;
import modelo.Libro;

import java.io.IOException;
import java.util.List;

public class LibroController {

    private LibroDAO libroDAO;

    public LibroController() {
        // Inicializa el objeto LibroDAO
        libroDAO = new LibroDAO();
    }

    // Métodos para gestionar las solicitudes del usuario
    public void crearLibro(String titulo, String autor, String isbn, int edicion) {
        // Crear un nuevo objeto Libro
        Libro nuevoLibro = new Libro(titulo, autor, isbn, edicion);

        try {
            // Llama al método de la capa de modelo para crear el libro en la base de datos
            LibroDAO libroDAO = new LibroDAO(); // Debes crear una instancia de LibroDAO aquí
            libroDAO.createLibro(nuevoLibro);
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar excepciones, por ejemplo, mostrar un mensaje de error en la vista
        }
    }

    public List<Libro> obtenerLibros() {
        List<Libro> libros = null;

        try {
            // Llama al método de la capa de modelo para obtener la lista de libros
            libros = libroDAO.readLibros();
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar excepciones, por ejemplo, mostrar un mensaje de error en la vista
        }

        return libros;
    }

    public void actualizarLibro(String isbn, String nuevoTitulo, String nuevoAutor, int nuevaEdicion) {
        try {
            // Llama al método de la capa de modelo para actualizar el libro en la base de datos
            libroDAO.updateLibro(new Libro(nuevoTitulo, nuevoAutor, isbn, nuevaEdicion));
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar excepciones, por ejemplo, mostrar un mensaje de error en la vista
        }
    }

    public void eliminarLibro(String isbn) {
        try {
            // Llama al método de la capa de modelo para eliminar el libro de la base de datos
            libroDAO.deleteLibro(isbn);
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar excepciones, por ejemplo, mostrar un mensaje de error en la vista
        }
    }
}
