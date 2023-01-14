/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.smy.security.repository;

import com.portfolio.smy.security.entity.Role;
import com.portfolio.smy.security.enums.RoleNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Role, Integer>{
    Optional<Role> findByRoleNombre(RoleNombre rolNombre);
}
