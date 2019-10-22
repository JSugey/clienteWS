package com.crudsa.clienteWS;

import com.crudsa.vo.LibroVO;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.description.OperationDesc;
import org.apache.axis.description.ParameterDesc;
import org.apache.log4j.Logger;

public class ClienteWS {
    private static final Logger logger = Logger.getLogger(ClienteWS.class);
     
    public ArrayList<LibroVO> listaLibros() throws Exception{
        ArrayList<LibroVO> libros = new ArrayList<>();
        try {
            String endpoint = "http://localhost:8080/crudSpringCFX/ws/v/libroService";
            Service servicio = new Service();
            Call _call = (Call) servicio.createCall();
            _call.setTargetEndpointAddress(new URL(endpoint));
            _call.setUseSOAPAction(true);
            _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
            
            OperationDesc operacion = new OperationDesc();
            operacion.setName("listaLibros");
            ParameterDesc param = new ParameterDesc(new QName("","arg0"),ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
            operacion.addParameter(param);
            operacion.setReturnType(new QName("http://ws.crudsa.com/", "listaLibrosResponse"));
            operacion.setReturnClass(LibroVO.class);
            operacion.setReturnQName(new QName("", "listaLibrosResponse"));
            
            _call.setOperation(operacion);
            _call.setOperationName( new QName("http://ws.crudsa.com/", "listaLibros"));
            Object resp = _call.invoke(new Object[]{"ad"});
            if (resp instanceof RemoteException) {
                throw (RemoteException)resp;
            } else{                
                try {                    
                    libros = (ArrayList)resp;
                } catch (Exception e) {
                    libros.add((LibroVO) resp);
                }
            }
        } catch (MalformedURLException | RemoteException | ServiceException e) {
            logger.debug("ERROR: "+e);
        }        
        return libros;
    }
    
    public ArrayList<LibroVO> buscarLibro(String nombreLibro) throws Exception{
        ArrayList<LibroVO> libros = new ArrayList<>();
        try {
            
            String endpoint = "http://localhost:8080/crudSpringCFX/ws/v/libroService";
            Service servicio = new Service();
            Call _call = (Call) servicio.createCall();
            
            OperationDesc operacion = new OperationDesc();
            operacion.setName("getLibroTitulo");
            ParameterDesc param = new ParameterDesc(new QName("","titulo"),ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
            operacion.addParameter(param);
            operacion.setReturnType(new QName("http://ws.crudsa.com/", "getLibroTituloResponse"));
            operacion.setReturnClass(LibroVO.class);
            operacion.setReturnQName(new QName("", "getLibroTituloResponse"));
            
            _call.setTargetEndpointAddress(new URL(endpoint));
            _call.setUseSOAPAction(true);
            _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);            
            _call.setOperation(operacion);
            _call.setOperationName( new QName("http://ws.crudsa.com/", "getLibroTitulo"));
            Object resp = _call.invoke(new Object[]{ nombreLibro });
            if (resp instanceof RemoteException) {
                throw (RemoteException)resp;
            } else{        
                try {                    
                    libros = (ArrayList)resp;
                } catch (Exception e) {
                    libros.add((LibroVO) resp);
                }
            }
        } catch (MalformedURLException | RemoteException | ServiceException e) {
            logger.debug("ERROR: "+e);
        }        
        return libros;
    }
    
    public LibroVO getLibro(int idLibro) throws Exception{
        LibroVO libro = new LibroVO();
        try {
            
            String endpoint = "http://localhost:8080/crudSpringCFX/ws/v/libroService";
            Service servicio = new Service();
            Call _call = (Call) servicio.createCall();
            
            OperationDesc operacion = new OperationDesc();
            operacion.setName("getLibro");
            ParameterDesc param = new ParameterDesc(new QName("","id"),ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), Integer.class, false, false);
            operacion.addParameter(param);
            operacion.setReturnType(new QName("http://ws.crudsa.com/", "getLibroResponse"));
            operacion.setReturnClass(LibroVO.class);
            operacion.setReturnQName(new QName("", "getLibroResponse"));
            
            _call.setTargetEndpointAddress(new URL(endpoint));
            _call.setUseSOAPAction(true);
            _call.setEncodingStyle(null);
            _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);            
            _call.setOperation(operacion);
            _call.setOperationName( new QName("http://ws.crudsa.com/", "getLibro"));
            Object resp = _call.invoke(new Object[]{ idLibro });
            if (resp instanceof RemoteException) {
                throw (RemoteException)resp;
            } else{                
                libro = (LibroVO)resp;
            }
        } catch (MalformedURLException | RemoteException | ServiceException e) {
            logger.debug("ERROR: "+e);
        }        
        return libro;
    }
    
    public String agregarLibro(LibroVO libro) throws Exception{
        String mensaje = "";
        try {
            
            String endpoint = "http://localhost:8080/crudSpringCFX/ws/v/libroService";
            Service servicio = new Service();
            Call _call = (Call) servicio.createCall();
            
            OperationDesc operacion = new OperationDesc();
            operacion.setName("guardarLibro");
            ParameterDesc param = new ParameterDesc(new QName("","id"),ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), Integer.class, false, false);
            operacion.addParameter(param);
            param = new ParameterDesc(new QName("","nombre"),ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
            operacion.addParameter(param);
            param = new ParameterDesc(new QName("","autor"),ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
            operacion.addParameter(param);
            param = new ParameterDesc(new QName("","genero"),ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
            operacion.addParameter(param);
            param = new ParameterDesc(new QName("","descripcion"),ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
            operacion.addParameter(param);
            param = new ParameterDesc(new QName("","imagen"),ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
            operacion.addParameter(param);
            operacion.setReturnType(new QName("http://ws.crudsa.com/", "guardarLibroResponse"));
            operacion.setReturnClass(String.class);
            operacion.setReturnQName(new QName("", "guardarLibroResponse"));
            
            _call.setTargetEndpointAddress(new URL(endpoint));
            _call.setUseSOAPAction(true);
            _call.setEncodingStyle(null);
            _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);            
            _call.setOperation(operacion);
            _call.setOperationName( new QName("http://ws.crudsa.com/", "guardarLibro"));
            Object resp = _call.invoke(new Object[]{ libro.getId(), libro.getNombre(), libro.getAutor(), libro.getGenero(), libro.getDescripcion(), libro.getImagen() });
            if (resp instanceof RemoteException) {
                throw (RemoteException)resp;
            } else{                
                mensaje = (String)resp;
            }
        } catch (MalformedURLException | RemoteException | ServiceException e) {
            logger.debug("ERROR: "+e);
        }        
        return mensaje;
    }
    
    public String eliminarLibro(int idLibro) throws Exception{
        String mensaje = "";
        try {
            
            String endpoint = "http://localhost:8080/crudSpringCFX/ws/v/libroService";
            Service servicio = new Service();
            Call _call = (Call) servicio.createCall();
            
            OperationDesc operacion = new OperationDesc();
            operacion.setName("eliminarLibro");
            ParameterDesc param = new ParameterDesc(new QName("","id"),ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), Integer.class, false, false);
            operacion.addParameter(param);
            operacion.setReturnType(new QName("http://ws.crudsa.com/", "eliminarLibroResponse"));
            operacion.setReturnClass(String.class);
            operacion.setReturnQName(new QName("", "eliminarLibroResponse"));
            
            _call.setTargetEndpointAddress(new URL(endpoint));
            _call.setUseSOAPAction(true);
            _call.setEncodingStyle(null);
            _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);            
            _call.setOperation(operacion);
            _call.setOperationName( new QName("http://ws.crudsa.com/", "eliminarLibro"));
            Object resp = _call.invoke(new Object[]{ idLibro });
            if (resp instanceof RemoteException) {
                throw (RemoteException)resp;
            } else{                
                mensaje = (String)resp;
            }
        } catch (MalformedURLException | RemoteException | ServiceException e) {
            logger.debug("ERROR: "+e);
        }        
        return mensaje;
    }
    
}
