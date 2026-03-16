package com.duoc.veterinaria.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    // ELIMINA: private static long contador = 1;
    private Long id;
    private Long citaId;
    private String pacienteNombre;
    private String dueno;
    private LocalDateTime fechaEmision;
    private List<String> servicios = new ArrayList<>();
    private List<String> medicamentos = new ArrayList<>();
    private Double total;

    public Factura() {
        this.fechaEmision = LocalDateTime.now();
        this.total = 0.0;
    }

    public Factura(Long citaId, String pacienteNombre, String dueno) {
        // ELIMINA: this.id = contador++;
        this.citaId = citaId;
        this.pacienteNombre = pacienteNombre;
        this.dueno = dueno;
        this.fechaEmision = LocalDateTime.now();
        this.total = 0.0;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCitaId() {
        return citaId;
    }

    public void setCitaId(Long citaId) {
        this.citaId = citaId;
    }

    public String getPacienteNombre() {
        return pacienteNombre;
    }

    public void setPacienteNombre(String pacienteNombre) {
        this.pacienteNombre = pacienteNombre;
    }

    public String getDueno() {
        return dueno;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public List<String> getServicios() {
        return servicios;
    }

    public void setServicios(List<String> servicios) {
        this.servicios = servicios;
    }

    public List<String> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<String> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}