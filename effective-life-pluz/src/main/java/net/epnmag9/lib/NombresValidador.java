package net.epnmag9.lib;

import java.util.regex.Pattern;

public class NombresValidador {
    private static String validFormat = "([\\wñáéíóüúÁÉÍÓÜÑ]+)(\\s([\\wñáéíóüúÁÉÍÓÜÑ]+)){3,3}";
    public static boolean validate(String string){
        return Pattern.matches(validFormat, string);
    }

 
}
