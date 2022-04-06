
package com.tienda.service;

import com.tienda.entity.Persona;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaService {

    public List<Persona> getPersona();
    public void savePersona(Persona persona);
    public Persona findPersona(Persona persona);
    public void deletePersona(Persona persona);

    public Persona find(Persona persona);

    public void deletePersona(Long idPersona);

}