package com.credibanco.assessment.library.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Oramirez
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Proveedores implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idProveedoresServicio;
    
    private String nombre;
  
    private String apellido;
 
    private Servicios serviciosIdServicios;
   
    private Zona zonaIdZonaTrabajo;


}
