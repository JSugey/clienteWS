package com.crudsa.clienteWS;

import com.crudsa.entity.ApiError;
import com.crudsa.entity.ApiResponseF;
import com.crudsa.entity.Folio;
import com.crudsa.entity.SolicitarFolio;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

public class ClienteWSRest {

    private static final Logger logger = Logger.getLogger(ClienteWSRest.class);
    private final String url;
    private final String usuario;
    private final String contrasena;
    
    public ClienteWSRest(){
        this.url = "http://15.192.41.157:7101/Siniestros/AMIS";
        this.usuario = "testuser";
        this.contrasena = "testuser1";
    }
    
    public ApiResponseF<Folio> solicitarFoliio(SolicitarFolio solicitud) {        
        ObjectMapper mapper = new ObjectMapper();
        ApiResponseF<Folio> respuesta = new ApiResponseF<>();
        HttpURLConnection conn = null;
        OutputStream os = null;
        InputStream is = null;
        try {
            String jsonStr = mapper.writeValueAsString(solicitud);

            URL url = new URL(this.url+"/sf/solicitar");
            conn = (HttpURLConnection) url.openConnection();
            
            String basicAuth = this.usuario + ":"+this.contrasena;
            String basicAuthEnc = "Basic "+Base64.getEncoder().encodeToString(basicAuth.getBytes());
            
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.addRequestProperty("Authorization", basicAuthEnc);

            os = conn.getOutputStream();
            os.write(jsonStr.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Error codigo: " + conn.getResponseCode());
            }

            is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String output="";
            String out;
            while ((out = br.readLine()) != null) {
                output = output+out;
            }
            System.out.println("jsonstr: "+output);
            
            respuesta = new ObjectMapper().readValue(output, ApiResponseF.class);
        } catch (Exception e) {
            respuesta = new ApiResponseF<>("false", null, null, null, new ApiError(true,e));
            logger.debug("ERROR: " + e);
        } finally {
            try {
                if (conn != null) {
                    conn.disconnect();
                    conn = null;
                }
                if (os != null) {
                    os.close();
                    os = null;
                }
                if (is != null) {
                    is.close();
                    is = null;
                }
            } catch (IOException e) {
                logger.debug("ERROR: " + e);
            }
        }
        return respuesta;
    }
}
