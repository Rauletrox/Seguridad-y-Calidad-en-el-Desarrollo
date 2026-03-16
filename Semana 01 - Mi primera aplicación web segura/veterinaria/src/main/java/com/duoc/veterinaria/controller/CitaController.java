package com.duoc.veterinaria.controller;

import com.duoc.veterinaria.model.Cita;
import com.duoc.veterinaria.model.Paciente;
import com.duoc.veterinaria.service.DataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

@Controller
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private DataStore dataStore;

    @GetMapping
    public String listarCitas(Model model) {
        model.addAttribute("citas", dataStore.getCitas());
        return "citas/lista";
    }

    @GetMapping("/nueva")
    public String mostrarFormularioNueva(Model model) {
        model.addAttribute("cita", new Cita());
        model.addAttribute("pacientes", dataStore.getPacientes());
        return "citas/nueva";
    }

    @PostMapping("/guardar")
    public String guardarCita(@RequestParam Long pacienteId,
            @RequestParam String fecha,
            @RequestParam String hora,
            @RequestParam String motivo,
            @RequestParam String veterinario) {

        try {
            Paciente paciente = dataStore.findPacienteById(pacienteId).orElse(null);
            if (paciente != null) {
                LocalDate fechaParsed = LocalDate.parse(fecha);
                LocalTime horaParsed = LocalTime.parse(hora);

                Cita cita = new Cita(
                        pacienteId,
                        paciente.getNombre(),
                        fechaParsed,
                        horaParsed,
                        motivo,
                        veterinario);
                dataStore.addCita(cita);
            }
        } catch (DateTimeParseException e) {
            return "redirect:/citas/nueva?error=formato";
        }

        return "redirect:/citas";
    }
}