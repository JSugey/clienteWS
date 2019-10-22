package com.crudsa.entity;

import java.sql.Timestamp;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SolicitarFolio {
    private String origen;
    private String destino;
    private Timestamp fechaAtencion;
    private String numeroSiniestro;

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getNumeroSiniestro() {
        return numeroSiniestro;
    }

    public void setNumeroSiniestro(String numeroSiniestro) {
        this.numeroSiniestro = numeroSiniestro;
    }

    public Timestamp getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(Timestamp fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public SolicitarFolio(String origen, String destino, Timestamp fechaAtencion, String numeroSiniestro) {
        this.origen = origen;
        this.destino = destino;
        this.fechaAtencion = fechaAtencion;
        this.numeroSiniestro = numeroSiniestro;
    }

    public SolicitarFolio() {
    }
    
}
