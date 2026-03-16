package com.duoc.veterinaria.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {
    // ELIMINA: private static long contador = 1;
    private Long id;
    private Long pacienteId;
    private String nombrePaciente;
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;
    private String veterinario;

    public Cita() {
    }

    public Cita(Long pacienteId, String nombrePaciente, LocalDate fecha,
            LocalTime hora, String motivo, String veterinario) {
        // ELIMINA: this.id = contador++;
        this.pacienteId = pacienteId;
        this.nombrePaciente = nombrePaciente;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.veterinario = veterinario;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }
}