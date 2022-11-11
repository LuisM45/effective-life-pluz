package net.epnmag9.effectivelifepluz.controllers;

import java.util.Date;

public class Paciente {
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
}
