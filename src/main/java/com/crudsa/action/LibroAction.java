package com.crudsa.action;

import com.crudsa.clienteWS.ClienteWSRest;
import com.crudsa.entity.Libro;
import com.crudsa.service.LibroService;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class LibroAction extends ActionSupport{
    private Libro libro;
    private List<Libro> listaLibro;
    private int idLibro;
    private String mensaje;
    private String tituloLibro;
    private String titulo;

    @Autowired
    private LibroService libroService;
    
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    private static final Logger logger = Logger.getLogger(LibroAction.class);
 
    public String busca() throws Exception {
        return "iBusca";
    }
    
    public String agregar(){
        titulo ="Agregar Libro";
        return "formulario";
    }
    
    public String editar(){
        titulo ="Editar Libro";
        return "formulario";
    }
    
    public String lista(){
        try {            
            listaLibro = libroService.lista();
            mensaje = "Se obtuvo lista de libros";
        } catch (Exception e) {
            logger.error("ERROR AL OBTENER LISTA: "+ e.getMessage());
        }
        return "lista";
    }
    
    public String buscar(){
        try {            
            listaLibro = libroService.buscar(tituloLibro);
            mensaje = "Se obtuvo lista de libros";
        } catch (Exception e) {
            logger.error("ERROR AL OBTENER LISTA: "+ e.getMessage());
        }
        return "busca";
    }
    
    public String obtener(){
        try {            
            libro = libroService.obtenerUno(idLibro);
            mensaje = "Se obtuvo lista de libros";
        } catch (Exception e) {
            logger.error("ERROR AL OBTENER LISTA: "+ e.getMessage());
        }
        mensaje = "Se obtuvo libro";
        return "obtener";
    }
    
    public String eliminar(){
        try {            
            mensaje = libroService.eliminar(idLibro);
        } catch (Exception e) {
            logger.error("ERROR AL Eliminar libro: "+ e.getMessage());
        }
        return lista();
    }
    
    public String guardar(){
        try {            
            mensaje = libroService.guardar(libro);
        } catch (Exception e) {
            logger.error("ERROR AL Guardar libro: "+ e.getMessage());
        }
        return lista();
    }
    
    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public List<Libro> getListaLibro() {
        return listaLibro;
    }

    public void setListaLibro(List<Libro> listaLibro) {
        this.listaLibro = listaLibro;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LibroService getLibroService() {
        return libroService;
    }

    public void setLibroService(LibroService libroService) {
        this.libroService = libroService;
    }    

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
}
