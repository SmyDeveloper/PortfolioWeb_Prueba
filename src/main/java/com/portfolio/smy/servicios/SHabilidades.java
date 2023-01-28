/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.smy.servicios;

import com.portfolio.smy.entidad.habilidades;
import com.portfolio.smy.repositorio.RHabilidades;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SHabilidades {
    @Autowired
    RHabilidades rhabilidades;
    
    public List<habilidades> list(){
        return rhabilidades.findAll();
    }
    
    public Optional<habilidades> getOne(int id){
        return rhabilidades.findById(id);
    }
    
    public Optional<habilidades> getByNombre (String nombre){
        return rhabilidades.findByNombre(nombre);
       
    }
    
    public void save (habilidades skill){
        rhabilidades.save(skill);
    }
    
    public void delete (int id){
        rhabilidades.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rhabilidades.existsById(id);
    }
    
    public boolean existsByNombre (String nombre){
        return rhabilidades.existsByNombre(nombre);
    }
    
}
