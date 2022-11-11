package net.epnmag9.effectivelifepluz.controllers;

import java.io.Serializable;
import java.util.Date;

public class EntradaDatosClinicos implements Serializable{
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

    @Override
    public String toString() {
        return "EntradaDatosClinicos [peso=" + peso + ", altura=" + altura + ", presionArterial=" + presionArterial
                + ", temperatura=" + temperatura + ", fechaIngreso=" + fechaIngreso + ", observaciones=" + observaciones
                + "]";
    }

    
}
