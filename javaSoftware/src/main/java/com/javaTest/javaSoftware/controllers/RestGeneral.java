package com.javaTest.javaSoftware.controllers;

import com.javaTest.javaSoftware.services.UsuariosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RestController
@RequestMapping(value = "/general")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RestGeneral {

    private final UsuariosService usuariosService;

    public RestGeneral(UsuariosService usuariosService){
        this.usuariosService = usuariosService;
    }

    @GetMapping(value = "/getAllEmployees", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<?>  getAllEmployees(){
        try {
            return ResponseEntity.status(HttpStatus.OK.value()).body(usuariosService.findAllEmpoyee());
        }catch (Exception e){
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body("Ha ocurrido un Error en solicitar los clientes");
        }
    }

    @GetMapping(value = "getEmployeeId/{indexEmployee}", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<?> getEmployeeId(@PathVariable(value = "indexEmployee") Integer indexEmployee){
        try {
            return ResponseEntity.status(HttpStatus.OK.value()).body(usuariosService.findByIdExactly(indexEmployee.longValue()));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body("Ha ocurrido un Error en solicitar cliente con indice: "+indexEmployee);
        }
    }

}
