package com.duoc.veterinaria.controller;

import com.duoc.veterinaria.model.Cita;
import com.duoc.veterinaria.model.Factura;
import com.duoc.veterinaria.model.Paciente;
import com.duoc.veterinaria.service.DataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private DataStore dataStore;

    @GetMapping
    public String listarFacturas(Model model) {
        model.addAttribute("facturas", dataStore.getFacturas());
        return "facturas/lista";
    }

    @GetMapping("/nueva/{citaId}")
    public String mostrarFormularioNueva(@PathVariable Long citaId, Model model) {
        // Buscar la cita
        Optional<Cita> citaOptional = dataStore.getCitas().stream()
                .filter(c -> c.getId().equals(citaId))
                .findFirst();

        if (citaOptional.isPresent()) {
            Cita cita = citaOptional.get();
            Optional<Paciente> pacienteOptional = dataStore.findPacienteById(cita.getPacienteId());

            if (pacienteOptional.isPresent()) {
                Paciente paciente = pacienteOptional.get();
                Factura factura = new Factura();
                factura.setCitaId(citaId);
                factura.setPacienteNombre(cita.getNombrePaciente());
                factura.setDueno(paciente.getDueno());

                model.addAttribute("factura", factura);
                model.addAttribute("cita", cita);
                return "facturas/nueva";
            }
        }

        return "redirect:/citas";
    }

    @PostMapping("/guardar")
    public String guardarFactura(@ModelAttribute Factura factura,
            @RequestParam(required = false) List<String> serviciosList,
            @RequestParam(required = false) List<String> medicamentosList) {

        if (serviciosList != null) {
            factura.getServicios().addAll(serviciosList);
        }
        if (medicamentosList != null) {
            factura.getMedicamentos().addAll(medicamentosList);
        }

        // Calcular total (simulado)
        double total = factura.getServicios().size() * 25000 + factura.getMedicamentos().size() * 5000;
        factura.setTotal(total);

        dataStore.addFactura(factura);
        return "redirect:/facturas";
    }

    @GetMapping("/ver/{id}")
    public String verFactura(@PathVariable Long id, Model model) {
        Optional<Factura> facturaOptional = dataStore.getFacturas().stream()
                .filter(f -> f.getId().equals(id))
                .findFirst();

        if (facturaOptional.isPresent()) {
            model.addAttribute("factura", facturaOptional.get());
            return "facturas/ver";
        }

        return "redirect:/facturas";
    }
}