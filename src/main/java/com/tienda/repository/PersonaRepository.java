
package com.tienda.repository;


import com.tienda.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<Person,Long>{
    Person findByNombre (String nombre);
    
}