
package com.portfolio.smy.controlador;

import com.portfolio.smy.entidad.persona;
import com.portfolio.smy.interfaces.IPersonaServicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "https://frontendsmy.web.app")
public class ControladorPersona {
    @Autowired 
    IPersonaServicios ipersonaServicios;
    
    @GetMapping("/traer")
    public List<persona> getPersona(){
        return ipersonaServicios.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String createPersona(@RequestBody persona persona){
        ipersonaServicios.savePersona(persona);
        return "El Registro fue creado de forma Exitosa";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaServicios.deletePersona(id);
        return "El registro fue eliminado de forma exitosa";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public persona edithPersona(@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("img") String nuevoImg){
        persona persona = ipersonaServicios.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        
        ipersonaServicios.savePersona(persona);
        return persona;
    }
    
    @GetMapping("/traer/perfil")
    public persona findPersona(){
        return ipersonaServicios.findPersona((long)2);
    }
    
}
