package com.credibanco.assessment.library.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.library.model.RqServicios;
import com.credibanco.assessment.library.model.RsServicio;
import com.credibanco.assessment.library.services.SolicitaProveedores;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/consulta")
@CrossOrigin("*")
@Slf4j
public class ServiciosRestController {

	@GetMapping(value = "/test")
	public String getTest() {
		return "Funciona";
	}

	@PostMapping(value = "/find",produces=MediaType.APPLICATION_JSON_VALUE)
	public String buscarServicios(@Valid @RequestBody(required = true) RqServicios requestServicios) {

		SolicitaProveedores solicitaproveedores = new SolicitaProveedores();
		String proveedores = null;
		try {
			proveedores = solicitaproveedores.ConsumeServicio(requestServicios);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return proveedores;
	}

}
