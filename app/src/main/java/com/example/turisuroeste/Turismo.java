package com.example.turisuroeste;

import java.io.Serializable;

public class Turismo implements Serializable {
    //Atributos
    String nombreActividad,description,fotoActividad;


    //Metodo constructor

    public Turismo(String nombreActividad, String description, String fotoActividad) {
        this.nombreActividad = nombreActividad;
        this.description = description;
        this.fotoActividad = fotoActividad;
    }

    //Metodos de encapsulado


    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFotoActividad() {
        return fotoActividad;
    }

    public void setFotoActividad(String fotoActividad) {
        this.fotoActividad = fotoActividad;
    }
}
