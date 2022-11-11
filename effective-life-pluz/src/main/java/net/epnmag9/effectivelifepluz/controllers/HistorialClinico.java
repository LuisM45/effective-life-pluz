package net.epnmag9.effectivelifepluz.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistorialClinico {
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

}
