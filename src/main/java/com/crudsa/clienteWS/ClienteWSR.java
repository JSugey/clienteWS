package com.crudsa.clienteWS;

import com.crudsa.entity.ApiError;
import com.crudsa.entity.ApiResponseF;
import com.crudsa.entity.Folio;
import com.crudsa.entity.SolicitarFolio;
import java.text.SimpleDateFormat;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class ClienteWSR {

    private static final Logger logger = Logger.getLogger(ClienteWSR.class);
    private final String url;
    private final String url2;
    private final String usuario;
    private final String contrasena;

    public ClienteWSR() {
        this.url = "http://15.192.41.157:7101/Siniestros/AMIS";
        this.url2 = "http://localhost:8081/Siniestros/AMIS";
        this.usuario = "testuser";
        this.contrasena = "testuser1";
    }

    public ApiResponseF<Folio> solicitarFolio(SolicitarFolio solicitud) {
        ObjectMapper mapper = new ObjectMapper();
        ApiResponseF<Folio> respuesta = new ApiResponseF<Folio>();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
            String fecha = sdf.format(solicitud.getFechaAtencion());
            String jsonS = "{\"origen\":\""+solicitud.getOrigen()+"\",\"destino\":\""+solicitud.getDestino()+"\",\"fechaAtencion\":\""+fecha+"\",\"numeroSiniestro\":\""+solicitud.getNumeroSiniestro()+"\"}";
            String jsonStr = mapper.writeValueAsString(solicitud);

            HttpAuthenticationFeature basAuth = HttpAuthenticationFeature.basic(this.usuario, this.contrasena);
            
            Client cliente = ClientBuilder.newClient();
            cliente.register(basAuth);
            WebTarget webTarget = cliente.target(this.url).path("sf/solicitar");
            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

            Response response = invocationBuilder.post(Entity.entity(jsonS, MediaType.APPLICATION_JSON));

            System.out.println(response.getStatus());

            if (response.getStatus() == 200) {
                String resp = response.readEntity(String.class);
                respuesta = mapper.readValue(resp, new TypeReference<ApiResponseF<Folio>>(){});
            } else{
                respuesta = new ApiResponseF<>("false", null, null, null, null);
            }
            
        } catch (Exception e) {
            respuesta = new ApiResponseF<>("false", null, null, null, new ApiError(true, e));
            logger.debug("ERROR: " + e);
        }
        return respuesta;
    }

}
