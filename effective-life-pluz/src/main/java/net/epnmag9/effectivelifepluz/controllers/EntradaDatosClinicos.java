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
        // Validar peso
        if(peso <= 0) throw new IllegalArgumentException("El peso no puede ser negativo ni igual a cero");
        if(altura <= 0) throw new IllegalArgumentException("La altura no puede ser negativa ni igual a cero");

        // Validar presion
        if(presionArterialSis <= presionArterialDia) throw new IllegalArgumentException("La presion sistólica no puede ser mayor a la diastólica");
        if(presionArterialSis <= 0) throw new IllegalArgumentException("La presion sistólica no puede ser menor ni igual a cero");
        if(presionArterialDia <= 0) throw new IllegalArgumentException("La presion diastólica no puede ser menor ni igual a cero");
        
        
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
