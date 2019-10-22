package com.crudsa.service;

import com.crudsa.clienteWS.ClienteWS;
import com.crudsa.vo.LibroVO;
import com.crudsa.entity.Libro;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LibroServiceImpl implements LibroService {
    
    private static final Logger logger = Logger.getLogger(ClienteWS.class);
    
    private ClienteWS clientews = new ClienteWS();

    @Override
    public String guardar(Libro libro) {
        String mensaje="";
        try {
            LibroVO libroVO = copyLibro(libro);
            mensaje = clientews.agregarLibro(libroVO);
        } catch (Exception e) {
            mensaje ="Error al agregar libro";
            logger.debug("ERROR: "+e);
        }
        return mensaje;
    }

    @Override
    public List<Libro> lista() { 
        ArrayList<LibroVO> librosVO;
        List<Libro> libros = new ArrayList<>();
        try {
            librosVO = clientews.listaLibros();
            for (LibroVO librosVO1 : librosVO) {
                Libro libro = copyLibroVO(librosVO1);
                libros.add(libro);
            }
        } catch (Exception ex) {
            logger.debug("ERROR: "+ex);
        }
        return libros;
    }
    
    @Override
    public List<Libro> buscar(String nombreLibro) {
        ArrayList<LibroVO> librosVO;
        List<Libro> libros = new ArrayList<>();
        try {
            librosVO = clientews.buscarLibro(nombreLibro);
            for (LibroVO librosVO1 : librosVO) {
                Libro libro = copyLibroVO(librosVO1);
                libros.add(libro);
            }
        } catch (Exception ex) {
            logger.debug("ERROR: "+ex);
        }
        return libros;
    }
    

    @Override
    public String eliminar(int id) {
       String mensaje="";
        try {
            mensaje = clientews.eliminarLibro(id);
        } catch (Exception e) {
            mensaje ="Error al agregar libro";
            logger.debug("ERROR: "+e);
        }
        return mensaje;
    }

    @Override
    public Libro obtenerUno(int id) {
        Libro libro = new Libro();
        try {
            LibroVO libroVO = clientews.getLibro(id);
            libro = copyLibroVO(libroVO);
        } catch (Exception ex) {
            logger.debug("ERROR: "+ex);
        }
        return libro;
    }

    @Override
    public Libro editar(Libro libro) {
        //return libroDao.updateLibro(libro);
        return null;
    }
    
    
    public Libro copyLibroVO(LibroVO libroVO){
        Libro libro = new Libro();
        libro.setId(Integer.parseInt(libroVO.getId()));
        libro.setNombre(libroVO.getNombre());
        libro.setAutor(libroVO.getAutor());
        libro.setDescripcion(libroVO.getDescripcion());
        libro.setGenero(libroVO.getGenero());
        libro.setImagen(libroVO.getImagen());
        return libro;
    }
    
    public LibroVO copyLibro(Libro libro){
        LibroVO libroVO = new LibroVO();
        libroVO.setId(libro.getId()+"");
        libroVO.setNombre(libro.getNombre());
        libroVO.setAutor(libro.getAutor());
        libroVO.setDescripcion(libro.getDescripcion());
        libroVO.setGenero(libro.getGenero());
        libroVO.setImagen(libro.getImagen());
        return libroVO;
    }

}
