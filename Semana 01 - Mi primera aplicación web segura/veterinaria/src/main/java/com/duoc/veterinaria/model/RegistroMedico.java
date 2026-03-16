package com.duoc.veterinaria.model;

import java.time.LocalDateTime;

public class RegistroMedico {
    // ELIMINA: private static long contador = 1;
    private Long id;
    private Long pacienteId;
    private String nombrePaciente;
    private LocalDateTime fechaConsulta;
    private String diagnostico;
    private String tratamiento;
    private String medicamentos;
    private String notas;

    public RegistroMedico() {
        this.fechaConsulta = LocalDateTime.now();
    }

    public RegistroMedico(Long pacienteId, String nombrePaciente, String diagnostico,
            String tratamiento, String medicamentos, String notas) {
        // ELIMINA: this.id = contador++;
        this.pacienteId = pacienteId;
        this.nombrePaciente = nombrePaciente;
        this.fechaConsulta = LocalDateTime.now();
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.medicamentos = medicamentos;
        this.notas = notas;
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

    public LocalDateTime getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(LocalDateTime fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
}