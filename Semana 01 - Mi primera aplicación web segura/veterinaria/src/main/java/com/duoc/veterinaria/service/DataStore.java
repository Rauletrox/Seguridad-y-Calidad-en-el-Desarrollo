package com.duoc.veterinaria.service;

import com.duoc.veterinaria.model.*;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DataStore {
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Paciente> pacientes = new ArrayList<>();
    private List<Cita> citas = new ArrayList<>();
    private List<RegistroMedico> registrosMedicos = new ArrayList<>();
    private List<Factura> facturas = new ArrayList<>();

    public DataStore() {
        // Inicializar usuarios de prueba
        usuarios.add(new Usuario("admin", "admin123", "ADMIN", "Administrador", "admin@veterinaria.com"));
        usuarios.add(new Usuario("veterinario", "vet123", "VETERINARIO", "Dr. Juan Pérez", "juan@veterinaria.com"));
        usuarios.add(new Usuario("recepcion", "recep123", "RECEPCION", "María González", "maria@veterinaria.com"));

        // ELIMINADO: Pacientes de ejemplo
        // Ahora la lista de pacientes comienza vacía
    }

    // Métodos para Usuarios
    public Optional<Usuario> findUsuarioByUsername(String username) {
        return usuarios.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();
    }

    public List<Usuario> getUsuarios() {
        return new ArrayList<>(usuarios);
    }

    // Métodos para Pacientes
    public List<Paciente> getPacientes() {
        return new ArrayList<>(pacientes);
    }

    public void addPaciente(Paciente paciente) {
        // Asignar ID secuencial basado en el tamaño de la lista
        Long nuevoId = (long) (pacientes.size() + 1);
        paciente.setId(nuevoId);

        pacientes.add(paciente);
        System.out.println("Paciente agregado. Total: " + pacientes.size());
        System.out.println("ID del paciente: " + paciente.getId());
    }

    public Optional<Paciente> findPacienteById(Long id) {
        return pacientes.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    // Métodos para Citas
    public List<Cita> getCitas() {
        return new ArrayList<>(citas);
    }

    public void addCita(Cita cita) {
        // Asignar ID secuencial basado en el tamaño de la lista
        Long nuevoId = (long) (citas.size() + 1);
        cita.setId(nuevoId);
        citas.add(cita);
        System.out.println("Cita agregada. ID: " + cita.getId());
    }

    // Métodos para Registros Médicos
    public List<RegistroMedico> getRegistrosMedicos() {
        return new ArrayList<>(registrosMedicos);
    }

    public List<RegistroMedico> getRegistrosByPaciente(Long pacienteId) {
        return registrosMedicos.stream()
                .filter(r -> r.getPacienteId().equals(pacienteId))
                .toList();
    }

    public void addRegistroMedico(RegistroMedico registro) {
        // Asignar ID secuencial basado en el tamaño de la lista
        Long nuevoId = (long) (registrosMedicos.size() + 1);
        registro.setId(nuevoId);
        registrosMedicos.add(registro);
        System.out.println("Registro médico agregado. ID: " + registro.getId());
    }

    // Métodos para Facturas
    public List<Factura> getFacturas() {
        return new ArrayList<>(facturas);
    }

    public void addFactura(Factura factura) {
        // Asignar ID secuencial basado en el tamaño de la lista
        Long nuevoId = (long) (facturas.size() + 1);
        factura.setId(nuevoId);
        facturas.add(factura);
        System.out.println("Factura agregada. ID: " + factura.getId());
    }
}