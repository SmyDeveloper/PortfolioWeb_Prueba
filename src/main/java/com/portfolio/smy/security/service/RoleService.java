/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.smy.security.service;

import com.portfolio.smy.security.entity.Role;
import com.portfolio.smy.security.enums.RoleNombre;
import com.portfolio.smy.security.repository.RolRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class RoleService {
    @Autowired
    RolRepository rolRepository;
    
    public Optional<Role> getByRoleNombre(RoleNombre roleNombre) {
        return rolRepository.findByRoleNombre(roleNombre);
        
    }
    
    public void save (Role role){
        rolRepository.save(role);
    }
}
