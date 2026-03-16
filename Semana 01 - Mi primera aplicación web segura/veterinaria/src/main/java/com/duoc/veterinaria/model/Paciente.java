package com.duoc.veterinaria.model;

public class Paciente {
    // ELIMINA esta línea: private static long contador = 1;
    private Long id;
    private String nombre;
    private String especie;
    private String raza;
    private Integer edad;
    private String dueno;

    public Paciente() {
        // No hacer nada aquí
    }

    public Paciente(String nombre, String especie, String raza, Integer edad, String dueno) {
        // ELIMINA: this.id = contador++;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.dueno = dueno;
    }

    // Getters y Setters...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDueno() {
        return dueno;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }
}