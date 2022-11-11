package net.epnmag9.effectivelifepluz.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistorialClinico implements Serializable{
    List<EntradaDatosClinicos> entradasDatosClinicos;

    public HistorialClinico(){
        entradasDatosClinicos = new ArrayList<>();
    }

    public EntradaDatosClinicos registerEntradaDatosClinicos(
        double peso,
        double altura,
        double presionArterial,
        double temperatura,
        Date fechaIngreso,
        String observaciones
    ){
        EntradaDatosClinicos newEntradaDatosClinicos = new EntradaDatosClinicos(
            peso,
            altura,
            presionArterial,
            temperatura,
            fechaIngreso,
            observaciones
        );
        entradasDatosClinicos.add(newEntradaDatosClinicos);
        return newEntradaDatosClinicos;
    }

    @Override
    public String toString() {
        if(entradasDatosClinicos.isEmpty())
            return "No existen registros";
        Iterable<String> ics = ()->entradasDatosClinicos.stream().map(t->t.toString()).iterator();
        return String.join("\n----------------------------------------\n",ics);
    }
    

}
