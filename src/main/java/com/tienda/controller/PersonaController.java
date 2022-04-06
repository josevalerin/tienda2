package com.tienda.controller;

import com.tienda.entity.Persona;
import com.tienda.service.IPersonaService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @GetMapping("/personas")
    public String index(Model model) {
        List<Persona> listaPersonas = personaService.getPersona();
        model.addAttribute("titulo", "Personas");
        model.addAttribute("personas", listaPersonas);
        return "personas";

    }

    @GetMapping("/nuevaPersona")
    public String nuevaPersona(Persona persona) {
        return "modificarPersona";
    }

    @PostMapping("/guardarPersona")
    public String guardarPersona(@ModelAttribute Persona persona) {
        personaService.savePersona(persona);
        return "redirect:/persona";
    }

    @GetMapping("/modificarPersona/{idPersona}")
    public String modificarPersona(Persona persona, Model model) {
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
    public String modificarPersona(Model model) {
        model.addAttribute("persona", new Persona());
        return "modificarPersona";
    }

}
