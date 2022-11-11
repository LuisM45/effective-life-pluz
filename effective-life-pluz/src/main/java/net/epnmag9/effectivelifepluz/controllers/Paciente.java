package net.epnmag9.effectivelifepluz.controllers;

import java.io.Serializable;
import java.util.Date;

public class Paciente implements Serializable{
    Identificador identificador;
    String nombre;
    Date fechaNacimiento;
    String tipoSangre;
    String sexo;
    HistorialClinico historialClinico;

    protected Paciente(Identificador identificador,
    String nombre,
    Date fechaNacimiento,
    String tipoSangre,
    String sexo){

        this.identificador = identificador;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
        this.sexo = sexo;
        this.historialClinico = new HistorialClinico();
    }

    

    @Override
    public String toString() {
        return "Paciente [identificador=" + identificador + ", nombre=" + nombre + ", fechaNacimiento="
                + fechaNacimiento + ", tipoSangre=" + tipoSangre + ", sexo=" + sexo +"]";
    }



    public HistorialClinico getHistorialClinico() {
        return historialClinico;
    }
    
}
