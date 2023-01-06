
package com.portfolio.smy.servicios;

import com.portfolio.smy.entidad.persona;
import com.portfolio.smy.interfaces.IPersonaServicios;
import com.portfolio.smy.repositorio.IPersonaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServicios implements IPersonaServicios {
    @Autowired IPersonaRepositorio iPersonaRepositorio;
    
    @Override
    public List<persona> getPersona() {
        List<persona> persona = iPersonaRepositorio.findAll();
        return persona;
    }

    @Override
    public void savePersona(persona persona) {
       iPersonaRepositorio.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
       iPersonaRepositorio.deleteById(id);
    }

    @Override
    public persona findPersona(Long id) {
        persona persona = iPersonaRepositorio.findById(id).orElse(null);
        return persona;
    }
    
}
