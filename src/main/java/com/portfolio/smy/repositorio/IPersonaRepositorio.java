
package com.portfolio.smy.repositorio;

import com.portfolio.smy.entidad.persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepositorio extends JpaRepository<persona,Integer> {
    public Optional<persona> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);  
}
