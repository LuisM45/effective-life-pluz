package net.epnmag9.lib;

import java.util.regex.Pattern;

public class CedulaEcuatorianaVal {
    public static boolean validate(String cedula){
        return checkFormatAndLength(cedula)
            && checkProvinceCode(cedula)
            && checkThirdDigit(cedula)
            && checkSum(cedula);
    }

    private static boolean checkFormatAndLength(String cedula){
        return Pattern.matches("\\d{10,10}", cedula);
    }

    private static boolean checkProvinceCode(String cedula){
        int provinceCode = Integer.parseInt(cedula.substring(0,2));
        return provinceCode < 24;
    }

    private static boolean checkThirdDigit(String cedula){
        int thirdDigit = Integer.parseInt(cedula.substring(2,3));
        return thirdDigit<=5;
    }

    private static boolean checkSum(String cedula){
        int digitAccumulator = 0;
        boolean isOddPlaced = true;
        for(char c: cedula.toCharArray()){
            int digitValue = Character.getNumericValue(c);
            if (isOddPlaced) digitValue *= 2;
            if (digitValue>=10) digitValue -= 9;
            digitAccumulator += digitValue;
            isOddPlaced = !isOddPlaced;
        }
        digitAccumulator %= 10;

        return digitAccumulator==0;
    }
    
}
