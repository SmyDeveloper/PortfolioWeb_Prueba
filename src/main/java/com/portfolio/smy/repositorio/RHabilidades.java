/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.smy.repositorio;

import com.portfolio.smy.entidad.habilidades;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RHabilidades extends JpaRepository<habilidades, Integer>{
    
    Optional<habilidades> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
    
    
}
