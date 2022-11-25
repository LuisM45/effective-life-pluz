package net.epnmag9.effectivelifepluz.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
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

    public List<EntradaDatosClinicos> getEntradaInBetween(Date startDate, Date endDate){
        if(startDate == null && endDate == null) return new ArrayList(entradasDatosClinicos);
        List<EntradaDatosClinicos> entradasValidas = new LinkedList<>();
        if(startDate != null && endDate == null){
            for(EntradaDatosClinicos edc: entradasDatosClinicos)
                if(startDate.compareTo(edc.fechaIngreso)<=0)
                    entradasValidas.add(edc);
            return entradasValidas;
        }
        if(startDate == null && endDate != null){
            for(EntradaDatosClinicos edc: entradasDatosClinicos)
                if(endDate.compareTo(edc.fechaIngreso)>=0)
                    entradasValidas.add(edc);
            return entradasValidas;
        }
        
        if(startDate != null && endDate != null){
            if(startDate.compareTo(endDate)>0) throw new IllegalArgumentException();
            for(EntradaDatosClinicos edc: entradasDatosClinicos)
                if(startDate.compareTo(edc.fechaIngreso)<=0 && endDate.compareTo(edc.fechaIngreso)>=0)
                    entradasValidas.add(edc);
            return entradasValidas;
        }
//        for(EntradaDatosClinicos entrada: entradasDatosClinicos){
//            if(startDate.compareTo(endDate)
//            entrada.fechaIngreso
//        }
        return entradasValidas;
    }
    
    @Override
    public String toString() {
        if(entradasDatosClinicos.isEmpty())
            return "No existen registros";
        Iterable<String> ics = ()->entradasDatosClinicos.stream().map(t->t.toString()).iterator();
        return String.join("\n----------------------------------------\n",ics);
    }
    

}
