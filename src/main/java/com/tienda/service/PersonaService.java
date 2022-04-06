
package com.tienda.service;

import com.tienda.entity.Persona;
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
    public List<Persona> getPersona() {
        return(List<Persona>)personaRepository.findAll();
    }

    @Override
    @Transactional
    public void savePersona(Persona persona) {
        personaRepository.save(persona);
    }
     @Override
     @Transactional
    public void deletePersona(Persona persona) {
       personaRepository.delete(persona);
    }


    @Override
    @Transactional
    public Persona findPersona(Persona persona) {
        return personaRepository.findById(persona.getId()).orElse(null);
    }

    @Override
    public Persona find(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void deletePersona(Long idPersona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}