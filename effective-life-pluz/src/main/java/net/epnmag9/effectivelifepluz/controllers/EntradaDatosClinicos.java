package net.epnmag9.effectivelifepluz.controllers;

import java.util.Date;

public class EntradaDatosClinicos {
    double peso;
    double altura;
    double presionArterial;
    double temperatura;
    Date fechaIngreso;
    String observaciones;

    public EntradaDatosClinicos(
        double peso,
        double altura,
        double presionArterial,
        double temperatura,
        Date fechaIngreso,
        String observaciones
    ){
        this.peso = peso;
        this.altura = altura;
        this.presionArterial = presionArterial;
        this.temperatura = temperatura;
        this.fechaIngreso = fechaIngreso;
        this.observaciones = observaciones;
    }
}
