package com.tienda.controller;

import com.tienda.entity.Pais;
import com.tienda.entity.Person;
import com.tienda.service.IPaisService;
import com.tienda.service.IPersonaService;
import com.tienda.service.PersonaReportService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class PersonaController {

    @Autowired
    private IPersonaService personaService;
    @Autowired
    private IPaisService paisService;

    @GetMapping("/verPersonas")
    public String persona(Model model) {
        List<Person> listaPersonas = personaService.getPersona();
        model.addAttribute("titulo", "persona");
        model.addAttribute("persona", listaPersonas);
        return "persona";
    }

    @PostMapping("/guardarPersona")
    public String persona(@ModelAttribute Person persona) {
        personaService.savePersona(persona);
        return "persona";
    }

    @GetMapping("/modificarPersona/{idPersona}")
    public String modificarPersona(Person persona, Model model) {
        persona = personaService.find(persona);
        model.addAttribute("persona", persona);
        return "modificarPersona";
    }

    @GetMapping("/eliminarPersona/{idPersona}")
    public String eliminarPersona(@PathVariable("id") Long idPersona) {
        personaService.deletePersona(idPersona);
        return "redirect:/persona";
    }

    @GetMapping("/personasN")
    public String crearPersona(Model model) {
        List<Pais> listaPais = paisService.listCountry();
        model.addAttribute("persona", new Person());
        model.addAttribute("paises", listaPais);
        return "modificarPersona";
    }
      @GetMapping("/editPersona/{id}")
    public String editarPersona(@PathVariable("id")Long idPersona, Model model) {
        Person persona = personaService.getPersonById(idPersona);
        List<Pais> listaPais = paisService.listCountry();
        model.addAttribute("persona",persona);
        model.addAttribute("paises", listaPais);
        return "modificarPersona";
    }
    
    @Autowired
    private PersonaReportService personaReportService;
    
    @GetMapping(value ="/ReportePersonas", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody
    byte[] getFile() throws IOException {
    try{ 
        FileInputStream fis = new FileInputStream(new File(personaReportService.generateReport()));
        byte[] targetArray = new byte[fis.available()];
        fis.read(targetArray);
        return targetArray; 
    } catch (FileNotFoundException e){
    
    e.printStackTrace();
    }catch(IOException e){
      e.printStackTrace();
    
    }
    return null;
    
    
    
    
    }
    
   

    

}
