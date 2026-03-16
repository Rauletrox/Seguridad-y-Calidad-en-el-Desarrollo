package com.duoc.veterinaria.controller;

import com.duoc.veterinaria.model.Paciente;
import com.duoc.veterinaria.service.DataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private DataStore dataStore;

    @GetMapping
    public String listarPacientes(Model model) {
        model.addAttribute("pacientes", dataStore.getPacientes());
        return "pacientes/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "pacientes/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarPaciente(@ModelAttribute Paciente paciente) {
        // Imprimir para depuración
        System.out.println("Guardando paciente: " + paciente.getNombre());
        System.out.println("ID antes de guardar: " + paciente.getId());

        dataStore.addPaciente(paciente);

        // Verificar después de guardar
        System.out.println("ID después de guardar: " + paciente.getId());

        return "redirect:/pacientes";
    }
}