package com.duoc.veterinaria.controller;

import com.duoc.veterinaria.model.Paciente;
import com.duoc.veterinaria.model.RegistroMedico;
import com.duoc.veterinaria.service.DataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registros-medicos")
public class RegistroMedicoController {

    @Autowired
    private DataStore dataStore;

    @GetMapping
    public String listarRegistros(Model model) {
        model.addAttribute("registros", dataStore.getRegistrosMedicos());
        return "registros/lista";
    }

    @GetMapping("/paciente/{pacienteId}")
    public String verRegistrosPaciente(@PathVariable Long pacienteId, Model model) {
        model.addAttribute("registros", dataStore.getRegistrosByPaciente(pacienteId));
        model.addAttribute("paciente", dataStore.findPacienteById(pacienteId).orElse(null));
        return "registros/paciente";
    }

    @GetMapping("/nuevo/{pacienteId}")
    public String mostrarFormularioNuevo(@PathVariable Long pacienteId, Model model) {
        Paciente paciente = dataStore.findPacienteById(pacienteId).orElse(null);
        if (paciente != null) {
            RegistroMedico registro = new RegistroMedico();
            registro.setPacienteId(pacienteId);
            registro.setNombrePaciente(paciente.getNombre());
            model.addAttribute("registro", registro);
            model.addAttribute("paciente", paciente);
        }
        return "registros/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarRegistro(@ModelAttribute RegistroMedico registro) {
        dataStore.addRegistroMedico(registro);
        return "redirect:/registros-medicos/paciente/" + registro.getPacienteId();
    }
}