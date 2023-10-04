/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Puesto19
 */
public interface LibroInter {

    void createLibro(Libro libro) throws IOException;

    List<Libro> readLibros() throws IOException;

    void updateLibro(Libro libro) throws IOException;

    void deleteLibro(String isbn) throws IOException;
}
