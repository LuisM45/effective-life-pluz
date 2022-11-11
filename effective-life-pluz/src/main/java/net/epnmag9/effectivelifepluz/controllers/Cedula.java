package net.epnmag9.effectivelifepluz.controllers;

public class Cedula extends Identificador{

    
    public Cedula(String cedula) {
        if(!validar(this.valor)){
            throw new java.lang.IllegalArgumentException("El valor de la cedula no es válido");
        }
        this.valor = cedula;
    }

    public static boolean validar(String cedula) {
        return net.epnmag9.lib.CedulaEcuatorianaVal.validate(cedula);
    }
    
}
