package com.example.demo.models;

import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {
    private Integer decimalNumber;
    private String romanNumber;

    public RomanNumerals(Integer decimalNumber, String romanNumber) {
        this.decimalNumber = decimalNumber;
        this.romanNumber = romanNumber;
    }

    public Integer getDecimalNumber() {
        return decimalNumber;
    }

    public void setDecimalNumber(Integer decimalNumber) {
        this.decimalNumber = decimalNumber;
    }

    public String getRomanNumber() {
        return romanNumber;
    }

    public void setRomanNumber(String romanNumber) {
        this.romanNumber = romanNumber;
    }

    public static RomanNumerals convertirANumerosRomanos(int numero) {
        int i, miles, centenas, decenas, unidades;
        String romano = "";

        //obtenemos cada cifra del número
        miles = numero / 1000;
        centenas = numero / 100 % 10;
        decenas = numero / 10 % 10;
        unidades = numero % 10;

        //millar
        for (i = 1; i <= miles; i++) {
            romano = romano + "M";
        }

        //centenas
        if (centenas == 9) {
            romano = romano + "CM";
        } else if (centenas >= 5) {
            romano = romano + "D";
            for (i = 6; i <= centenas; i++) {
                romano = romano + "C";
            }
        } else if (centenas == 4) {
            romano = romano + "CD";
        } else {
            for (i = 1; i <= centenas; i++) {
                romano = romano + "C";
            }
        }

        //decenas
        if (decenas == 9) {
            romano = romano + "XC";
        } else if (decenas >= 5) {
            romano = romano + "L";
            for (i = 6; i <= decenas; i++) {
                romano = romano + "X";
            }
        } else if (decenas == 4) {
            romano = romano + "XL";
        } else {
            for (i = 1; i <= decenas; i++) {
                romano = romano + "X";
            }
        }

        //unidades
        if (unidades == 9) {
            romano = romano + "IX";
        } else if (unidades >= 5) {
            romano = romano + "V";
            for (i = 6; i <= unidades; i++) {
                romano = romano + "I";
            }
        } else if (unidades == 4) {
            romano = romano + "IV";
        } else {
            for (i = 1; i <= unidades; i++) {
                romano = romano + "I";
            }
        }
        return new RomanNumerals(numero,romano);
    }


    public static RomanNumerals romanToInteger(String roman)
    {
        Map<Character,Integer> numbersMap = new HashMap<>();
        numbersMap.put('I',1);
        numbersMap.put('V',5);
        numbersMap.put('X',10);
        numbersMap.put('L',50);
        numbersMap.put('C',100);
        numbersMap.put('D',500);
        numbersMap.put('M',1000);

        int result=0;

        for(int i=0;i<roman.length();i++)
        {
            char ch = roman.charAt(i);      // Current Roman Character

            //Case 1
            if(i>0 && numbersMap.get(ch) > numbersMap.get(roman.charAt(i-1)))
            {
                result += numbersMap.get(ch) - 2*numbersMap.get(roman.charAt(i-1));
            }

            // Case 2: just add the corresponding number to result.
            else
                result += numbersMap.get(ch);
        }

        return new RomanNumerals(result,roman);
    }
}
