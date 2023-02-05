
package com.portfolio.smy.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Size(min = 1, max = 255, message = "Debe colocar un nombre con los siguientes parámetros minimo=1 caracter máximo= 255")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 255, message = "Debe colocar un nombre con los siguientes parámetros minimo=1 caracter máximo= 255")
    private String apellido;
    
    @NotNull
    @Size(min = 1, max = 255, message = "Debe colocar una descripcion con los siguientes parámetros minimo=1 caracter máximo= 255")
    private String descripcion;
    
    
    private String img;

    public persona() {
    }

    public persona(String nombre, String apellido, String descripcion, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.img = img;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
}
