
package com.portfolio.smy.interfaces;

import com.portfolio.smy.entidad.persona;
import java.util.List;



public interface IPersonaServicios {
    //Un ArrayList de la Clase para poder ejecutar acá
    public List<persona> getPersona();
    
    public void savePersona(persona persona);
            
    public void deletePersona(Long id);
    
    public persona findPersona(Long id);
}
