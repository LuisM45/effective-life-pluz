package net.epnmag9.lib;

import java.util.regex.Pattern;

public class CedulaEcuatorianaVal {
    public static boolean validate(String cedula){
        Pattern.matches("\\d{10,10}", cedula);

        int provinceCode = Integer.parseInt(cedula.substring(0,2));
        if(provinceCode>24) return false;
        
        int justSix = Integer.parseInt(cedula.substring(2,3));
        if(justSix>5) return false;

        int digitAccumulator = 0;
        int parity = 1;
        for(char c: cedula.substring(0, 9).toCharArray()){
            int digitValue = Character.getNumericValue(c)*(1+parity);
            if (digitValue>=10) digitValue -= 9;
            digitAccumulator += digitValue;
            parity = (parity+1)%2;
        }
        int verifyingDigit = digitAccumulator%10;
        if (verifyingDigit != Character.getNumericValue(cedula.charAt(9))) return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(validate("1728086040"));
    }
}
