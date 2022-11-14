package net.epnmag9.lib;

import java.util.regex.Pattern;

public class CedulaEcuatorianaVal {
    public static boolean validate(String cedula){
        if(!Pattern.matches("\\d{10,10}", cedula)) return false;

        int provinceCode = Integer.parseInt(cedula.substring(0,2));
        if(provinceCode>24) return false;
        
        int thirdDigit = Integer.parseInt(cedula.substring(2,3));
        if(thirdDigit>5) return false;

        int digitAccumulator = 0;
        boolean isOddPlaced = true;
        for(char c: cedula.toCharArray()){
            int digitValue = Character.getNumericValue(c);
            if (isOddPlaced) digitValue *= 2;
            if (digitValue>=10) digitValue -= 9;
            digitAccumulator += digitValue;
        }
        digitAccumulator %= 10;

        return digitAccumulator==0;
    }
}
