package net.epnmag9.effectivelifepluz.controllers;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Paciente implements Serializable{
    Identificador identificador;
    String nombre;
    Date fechaNacimiento;
    TipoSanguineo tipoSanguineo;
    String sexo;
    HistorialClinico historialClinico;

    protected Paciente(Identificador identificador,
    String nombre,
    Date fechaNacimiento,
    TipoSanguineo tipoSangre,
    String sexo){
        if(tipoSanguineo==null) throw new IllegalArgumentException("El tipo sanguineo no puede ser null");
        
        this.identificador = identificador;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSanguineo = tipoSangre;
        this.sexo = sexo;
        this.historialClinico = new HistorialClinico();
    }


    @Override
    public String toString() {
        return "Paciente [identificador=" + identificador + ", nombre=" + nombre + ", fechaNacimiento="
                + fechaNacimiento + ", tipoSangre=" + tipoSanguineo + ", sexo=" + sexo +"]";
    }



    public HistorialClinico getHistorialClinico() {
        return historialClinico;
    }

}
