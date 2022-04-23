
package com.tienda.service;


import com.tienda.entity.Person;
import com.tienda.repository.PersonaRepository;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    @Autowired  
    private PersonaRepository personaRepository;
    
    @Override   
    @Transactional(readOnly=true)
    public List<Person> getPersona() {
        return(List<Person>)personaRepository.findAll();
    }

    @Override
    @Transactional
    public void savePersona(Person persona) {
        personaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long idPersona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Person getPersonById(Long idPersona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Person find(Person persona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public Person findByNombre(String nombre){
    return personaRepository.findByNombre(nombre);
    }


}