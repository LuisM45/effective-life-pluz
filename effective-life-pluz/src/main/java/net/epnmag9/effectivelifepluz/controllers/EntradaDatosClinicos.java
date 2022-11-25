package net.epnmag9.effectivelifepluz.controllers;

import java.io.Serializable;
import java.util.Date;

public class EntradaDatosClinicos implements Serializable{
    double peso;
    double altura;
    double presionArterialSis;
    double presionArterialDia;
    double temperatura;
    Date fechaIngreso;
    String observaciones;

    public EntradaDatosClinicos(
        double peso,
        double altura,
        double presionArterialSis,
        double presionArterialDia,
        double temperatura,
        Date fechaIngreso,
        String observaciones
    ){
        this.peso = peso;
        this.altura = altura;
        this.presionArterialSis = presionArterialSis;
        this.presionArterialDia = presionArterialDia;
        this.temperatura = temperatura;
        this.fechaIngreso = fechaIngreso;
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "EntradaDatosClinicos [peso=" + peso + ", altura=" + altura + ", presionArterialSis=" + presionArterialSis + ", presionArterialDia=" + presionArterialDia
                + ", temperatura=" + temperatura + ", fechaIngreso=" + fechaIngreso + ", observaciones=" + observaciones
                + "]";
    }

    
}
