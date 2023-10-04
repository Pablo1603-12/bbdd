package Test;

import java.io.IOException;
import modelo.Libro;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Puesto19
 */


public class Test {

    public static void main(String[] args) throws IOException {
        Libro bibliotecaHP[]=new Libro[3];
        Libro bibliotecaSA[]=new Libro[3];
 
        //Creamos objetos en cada posicion
        bibliotecaHP[0]=new Libro("Harry Potter y la piedra filofal", "Rowling, J.K.", "9780807286001", 3);
        bibliotecaHP[1]=new Libro("Harry Potter y las reliquias de la muerte", "Rowling, J.K.", "9780807286002", 2);
        bibliotecaHP[2]=new Libro("Harry Potter y el caliz de fuego", "Rowling, J.K.", "9780807286003", 8);
        
        bibliotecaSA[0]=new Libro("El señor de los anillos", "J. R. R. Tolkien", "9788845292613",2);
                    
        
        System.out.println("----------------------------------------------------------");
        
       // bibliotecaHP[1].createLibro();
        
      //  bibliotecaHP[1].readLibro();
    }

}
