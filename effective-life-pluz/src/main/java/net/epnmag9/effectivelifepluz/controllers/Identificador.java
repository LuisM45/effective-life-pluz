package net.epnmag9.effectivelifepluz.controllers;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class Identificador implements Serializable{
    protected String valor;
    private static Map<String,Function<String,Identificador>> recognizedIdentifiers;
    public final static Map<String,Function<String,Identificador>> recognizedIdentifiersView;
    static{
        recognizedIdentifiers = new HashMap<>();
        recognizedIdentifiers.put("Cédula", Cedula::valueOf);
        recognizedIdentifiersView = Collections.unmodifiableMap(recognizedIdentifiers);
    }

    public static Class<?> identify(String valor){
        if(Cedula.validate(valor)) return Cedula.class;
        return null;
    }

    public static Identificador buildIdentificador(String valor,String tipo){
        Function<String,Identificador> builder = recognizedIdentifiers.get(tipo);
        if (builder == null) return null;
        return builder.apply(valor);
    }

    @Override
    public boolean equals(Object obj) {
        if(!Identificador.class.isInstance(obj)) return false;
        return valor.equals(((Identificador)obj).valor);
    }

    @Override
    public int hashCode() {
        return valor.hashCode();
    }

    @Override
    public String toString() {
        return "Identificador [" + valor + "]";
    }

    

    
}
