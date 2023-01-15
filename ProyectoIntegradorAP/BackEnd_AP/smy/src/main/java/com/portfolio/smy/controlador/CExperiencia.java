/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.smy.controlador;

import com.portfolio.smy.Dto.dtoExperiencia;
import com.portfolio.smy.entidad.Experiencia;
import com.portfolio.smy.security.controller.Mensaje;
import com.portfolio.smy.servicios.SExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("explab")
@CrossOrigin(origins = "http://localhost:4200")
public class CExperiencia {
    @Autowired
    SExperiencia sExperiencia;
    
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
     @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoExp){
        if(StringUtils.isBlank(dtoExp.getNombreE()))
            return new ResponseEntity(new Mensaje("Se requiere un nombre de forma obligatoria"), HttpStatus.BAD_REQUEST);
        
        if(sExperiencia.existsByNombreE(dtoExp.getNombreE()))
            return new ResponseEntity(new Mensaje("Experiencia existente, coloque otra"), HttpStatus.BAD_REQUEST);
        
        Experiencia expriencia = new Experiencia(dtoExp.getNombreE(), dtoExp.getDescripcionE());
        sExperiencia.save(expriencia);
        
        return new ResponseEntity(new Mensaje ("Experiencia Agregada de Forma Exitosa"), HttpStatus.OK);
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoExp){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("ID INEXISTENTE"), HttpStatus.BAD_REQUEST);
        
        if(sExperiencia.existsByNombreE(dtoExp.getNombreE())&& sExperiencia.getByNombreE(dtoExp.getNombreE()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("Experiencia ya existente, agregue otra"), HttpStatus.BAD_REQUEST);
        
        if (StringUtils.isBlank(dtoExp.getNombreE()))
            return new ResponseEntity(new Mensaje ("El Campo Nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia  = sExperiencia.getOne(id).get();
        experiencia.setNombreE(dtoExp.getNombreE());
        experiencia.setDescripcionE(dtoExp.getDescripcionE());
        
        sExperiencia.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia Actualizada"), HttpStatus.OK);
        
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("ID no existe"), HttpStatus.BAD_REQUEST);
        
        sExperiencia.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia Eliminada de form Exitosa"), HttpStatus.OK);
    }
    
}
