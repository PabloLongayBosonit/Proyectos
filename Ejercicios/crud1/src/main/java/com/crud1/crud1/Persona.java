package com.crud1.crud1;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Persona {
    @Id
    @GeneratedValue
    private int id;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;

    public void Validador() throws Exception{
        if(usuario == null || usuario.length()<6 || usuario.length() > 10)
        {
            throw new RuntimeException("El usuario no puede ser nulo, debe tener entre 6 y 10 caracteres");
        }
        if(password == null)
        {
            throw new RuntimeException("Password no puede ser nulo");
        }
        if(name == null)
        {
            throw new RuntimeException("El nombre no puede ser nulo");
        }
        if(personal_email == null)
        {
            throw new RuntimeException("El personal_email no puede ser nulo");
        }
        if(city == null)
        {
            throw new RuntimeException("La ciudad no puede ser nulo");
        }
        if(created_date ==null)
        {
            throw new RuntimeException("La fecha creada no puede ser nula");
        }
    }
}
