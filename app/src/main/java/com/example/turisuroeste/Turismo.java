package com.example.turisuroeste;

import java.io.Serializable;

public class Turismo implements Serializable {
    //Atributos
    String nombreActividad;
    int fotoActividad;

    //Metodo constructor

    public Turismo(String nombreActividad, int fotoActividad) {
        this.nombreActividad = nombreActividad;
        this.fotoActividad = fotoActividad;
    }

    //Metodos de encapsulado

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public int getFotoActividad() {
        return fotoActividad;
    }

    public void setFotoActividad(int fotoActividad) {
        this.fotoActividad = fotoActividad;
    }
}
