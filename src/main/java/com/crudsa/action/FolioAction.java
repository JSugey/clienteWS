package com.crudsa.action;

import com.crudsa.clienteWS.ClienteWSR;
import com.crudsa.clienteWS.ClienteWSRest;
import com.crudsa.entity.ApiResponseF;
import com.crudsa.entity.SolicitarFolio;
import com.crudsa.entity.Folio;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Timestamp;
import org.apache.log4j.Logger;

public class FolioAction extends ActionSupport{
    private Folio folio;
    private String mensaje;
    private static final Logger logger = Logger.getLogger(FolioAction.class);
    private ClienteWSRest clientewsRest = new ClienteWSRest();
    private ClienteWSR clienteWS = new ClienteWSR();
    
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String solicitar(){
        try {            
            Timestamp fecha = new Timestamp(System.currentTimeMillis());
            SolicitarFolio solicitud = new SolicitarFolio("ORG", "DES", fecha, "100230");
            //ApiResponseF<Folio> respuesta= clientewsRest.solicitarFoliio(solicitud);
            ApiResponseF<Folio> respuesta= clienteWS.solicitarFolio(solicitud);
            folio = respuesta.getData();
            mensaje = "Se obtuvo lista de libros";
        } catch (Exception e) {
            logger.error("ERROR AL SOLICITAR FOLIO: "+ e.getMessage());
        }
        return SUCCESS;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Folio getFolio() {
        return folio;
    }

    public void setFolio(Folio folio) {
        this.folio = folio;
    }
    
}
