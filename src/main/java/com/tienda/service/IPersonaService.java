
package com.tienda.service;


import com.tienda.entity.Person;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaService {

    public List<Person> getPersona();
    public void savePersona(Person persona);
    public Person find(Person persona);
    public void deletePersona(Long idPersona);
    public Person getPersonById(Long idPersona);
    public Person findByNombre (String nombre);

}