
package com.crudsa.service;

import com.crudsa.entity.Libro;
import java.util.List;

public interface LibroService {
    
    String guardar(Libro libro);
    
    List<Libro> lista();
    
    String eliminar(int id);
    
    Libro obtenerUno(int id);
    
    Libro editar(Libro libro);
    
    List<Libro> buscar(String nombre);
}
