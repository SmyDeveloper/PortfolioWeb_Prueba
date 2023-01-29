package com.portfolio.smy.servicios;

import com.portfolio.smy.entidad.persona;
import com.portfolio.smy.repositorio.IPersonaRepositorio;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonaServicios {

    @Autowired
    IPersonaRepositorio iPersonaRepositorio;
    
      public List<persona> list(){
        return iPersonaRepositorio.findAll();
    }
    
    
    public Optional<persona> getOne(int id){
        return iPersonaRepositorio.findById(id);
    }
    
    public Optional<persona> getByNombre(String nombre){
        return iPersonaRepositorio.findByNombre(nombre);
    }
    
    public void save(persona persona){
        iPersonaRepositorio.save(persona);
    }
    
    public void delete(int id){
        iPersonaRepositorio.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iPersonaRepositorio.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return iPersonaRepositorio.existsByNombre(nombre);
    }
    
}
