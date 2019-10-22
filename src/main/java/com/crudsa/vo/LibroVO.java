
package com.crudsa.vo;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class LibroVO implements Serializable {
    private String id;
    private String nombre;
    private String autor;
    private String genero;
    private String descripcion;
    private String imagen;

    public LibroVO() {
    }

    public LibroVO(String id, String nombre, String autor, String genero, String descripcion, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }   
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    private Object equalsCalc = null;
    @Override
    public synchronized boolean equals(Object obj){
        if (!(obj instanceof LibroVO)) {
            return false;
        }
        LibroVO other = (LibroVO) obj;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (equalsCalc != null) {
            return (equalsCalc==obj);
        }
        equalsCalc = obj;
        boolean _equals;
        _equals = true && 
                ((this.id==null && other.getId()==null) || 
                (this.id!=null &&
                 this.id.equals(other.getId()))) &&
                ((this.nombre==null && other.getNombre()==null) || 
                (this.nombre!=null &&
                 this.nombre.equals(other.getNombre()))) &&
                ((this.autor==null && other.getAutor()==null) || 
                (this.autor!=null &&
                 this.autor.equals(other.getAutor()))) &&
                ((this.genero==null && other.getGenero()==null) || 
                (this.genero!=null &&
                 this.genero.equals(other.getGenero()))) &&
                ((this.descripcion==null && other.getDescripcion()==null) || 
                (this.descripcion!=null &&
                 this.descripcion.equals(other.getDescripcion()))) &&
                ((this.imagen==null && other.getImagen()==null) || 
                (this.imagen!=null &&
                 this.imagen.equals(other.getImagen())));
        equalsCalc = null;
        return _equals;       
    }
    
    private boolean hashCodeCalc = false;
    @Override
    public synchronized int hashCode() {
        if (hashCodeCalc) {
            return 0;
        }
        hashCodeCalc = true;
        int _hashCode = 1;
        if (getId()!= null) {
            _hashCode += getId().hashCode();
        }
        if (getNombre()!= null) {
            _hashCode += getNombre().hashCode();
        }
        if (getAutor()!= null) {
            _hashCode += getAutor().hashCode();
        }
        if (getGenero()!= null) {
            _hashCode += getGenero().hashCode();
        }
        if (getDescripcion()!= null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getImagen()!= null) {
            _hashCode += getImagen().hashCode();
        }
        hashCodeCalc = false;
        return _hashCode;
    }
    
    private static TypeDesc typeDesc = new TypeDesc(LibroVO.class, true);
    
    static{
        typeDesc.setXmlType(new QName("http://ws.crudsa.com/", "libroVO"));
        ElementDesc elemField = new ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new QName("http://ws.crudsa.com/", "id"));
        elemField.setArrayType(new QName("http://ws.crudsa.com/", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        
        elemField = new ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new QName("http://ws.crudsa.com/", "nombre"));
        elemField.setArrayType(new QName("http://ws.crudsa.com/", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        
        elemField = new ElementDesc();
        elemField.setFieldName("genero");
        elemField.setXmlName(new QName("http://ws.crudsa.com/", "genero"));
        elemField.setArrayType(new QName("http://ws.crudsa.com/", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        
        elemField = new ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new QName("http://ws.crudsa.com/", "descripcion"));
        elemField.setArrayType(new QName("http://ws.crudsa.com/", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        
        elemField = new ElementDesc();
        elemField.setFieldName("autor");
        elemField.setXmlName(new QName("http://ws.crudsa.com/", "autor"));
        elemField.setArrayType(new QName("http://ws.crudsa.com/", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        
        elemField = new ElementDesc();
        elemField.setFieldName("imagen");
        elemField.setXmlName(new QName("http://ws.crudsa.com/", "imagen"));
        elemField.setArrayType(new QName("http://ws.crudsa.com/", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }
    
    public static TypeDesc getTypeDesc(){
        return typeDesc;
    }
    
    public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType){
        return new BeanSerializer(_javaType, _xmlType, typeDesc);
    }
    
    public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType){
        return new BeanDeserializer(_javaType, _xmlType, typeDesc);
    }
}
