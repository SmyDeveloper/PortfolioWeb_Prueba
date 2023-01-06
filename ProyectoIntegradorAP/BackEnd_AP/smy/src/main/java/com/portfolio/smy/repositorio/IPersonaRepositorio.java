
package com.portfolio.smy.repositorio;

import com.portfolio.smy.entidad.persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepositorio extends JpaRepository<persona,Long> {
    
    
    
}
