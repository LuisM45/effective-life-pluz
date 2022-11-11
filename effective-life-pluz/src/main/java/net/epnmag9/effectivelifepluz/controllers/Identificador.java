package net.epnmag9.effectivelifepluz.controllers;

public abstract class Identificador {
    protected String valor;
    public static Class<?> identify(String valor){
        if(Cedula.validar(valor)) return Cedula.class;
        return null;
    }
}
