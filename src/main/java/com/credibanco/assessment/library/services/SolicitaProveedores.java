package com.credibanco.assessment.library.services;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.credibanco.assessment.library.model.Proveedores;
import com.credibanco.assessment.library.model.RqServicios;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SolicitaProveedores {

	@Autowired
	Constantes constantes;

	private static final Logger LOGGER = LoggerFactory.getLogger(SolicitaProveedores.class.getName());

	public String ConsumeServicio(RqServicios requestServicios) throws Exception {
		
		
		URL url = new URL("http://localhost:8080/servicios/disponibles");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        
        String input = "{\r\n"
        		+ "  \"servicio\": "+requestServicios.getServicio()+",\r\n"
        		+ "  \"zona\": "+requestServicios.getZona()+"\r\n"
        		+ "}";

        OutputStream os = conn.getOutputStream();
        os.write(input.getBytes());
        os.flush();

        if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Failed : HTTP error code : "
                + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        String outputt = "";
       
        String output;
		while ((output = br.readLine()) != null) {
        	outputt= outputt+output;
        }

        System.out.println(outputt);
        conn.disconnect();

		return outputt;
	}

}
