/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.smy.controlador;

import com.portfolio.smy.Dto.dtoHabilidades;
import com.portfolio.smy.entidad.habilidades;
import com.portfolio.smy.security.controller.Mensaje;
import com.portfolio.smy.servicios.SHabilidades;
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
@RequestMapping("/habilidades")
@CrossOrigin(origins = "https://frontendsmy.web.app")

public class CHabilidades {
    @Autowired
    SHabilidades shabilidades;
    
      @GetMapping("/lista")
    public ResponseEntity<List<habilidades>> list(){
        List<habilidades> list = shabilidades.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
     @GetMapping("/detail/{id}")
    public ResponseEntity<habilidades> getById(@PathVariable("id") int id){
        if(!shabilidades.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        habilidades habilidades = shabilidades.getOne(id).get();
        return new ResponseEntity(habilidades, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHabilidades dtohabilidades){
        if(StringUtils.isBlank(dtohabilidades.getNombre()))
            return new ResponseEntity(new Mensaje("Se requiere un nombre de forma obligatoria"), HttpStatus.BAD_REQUEST);
        
        if(shabilidades.existsByNombre(dtohabilidades.getNombre()))
            return new ResponseEntity(new Mensaje("Skill existente, coloque otra"), HttpStatus.BAD_REQUEST);
        
        habilidades habilidades = new habilidades(dtohabilidades.getNombre(), dtohabilidades.getPorcentaje());
        shabilidades.save(habilidades);
        
        return new ResponseEntity(new Mensaje ("Skill Agregada de Forma Exitosa"), HttpStatus.OK);
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHabilidades dtohabilidades){
        if(!shabilidades.existsById(id))
            return new ResponseEntity(new Mensaje("ID INEXISTENTE"), HttpStatus.BAD_REQUEST);
        
        if(shabilidades.existsByNombre(dtohabilidades.getNombre())&& shabilidades.getByNombre(dtohabilidades.getNombre()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("Experiencia ya existente, agregue otra"), HttpStatus.BAD_REQUEST);
        
        if (StringUtils.isBlank(dtohabilidades.getNombre()))
            return new ResponseEntity(new Mensaje ("El Campo SKILL es Obligatorio"), HttpStatus.BAD_REQUEST);
        
        
        habilidades habilidades  = shabilidades.getOne(id).get();
        habilidades.setNombre(dtohabilidades.getNombre());
        habilidades.setPorcentaje(dtohabilidades.getPorcentaje());
        
        shabilidades.save(habilidades);
        
        return new ResponseEntity(new Mensaje("Habilidad Actualizada"), HttpStatus.OK);
        
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!shabilidades.existsById(id))
            return new ResponseEntity(new Mensaje("Habilidad/id no existe"), HttpStatus.BAD_REQUEST);
        
           shabilidades.delete(id);
        
        return new ResponseEntity(new Mensaje("Habilidad Eliminada de form Exitosa"), HttpStatus.OK);
    }
    
    
}
