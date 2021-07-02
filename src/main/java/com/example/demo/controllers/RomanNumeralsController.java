package com.example.demo.controllers;

import com.example.demo.models.RomanNumerals;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/roman")
public class RomanNumeralsController {
    @GetMapping(path = "/get-roman")
    public RomanNumerals getRomanNumber(@RequestParam(name = "number",defaultValue = "0") Integer number){
        if (number > 0 && number < 3999){
            return RomanNumerals.convertirANumerosRomanos(number);
        }else{
            return new RomanNumerals(number,"out of scope");
        }
    }
    @GetMapping(path ="/get-number")
    public RomanNumerals getNumberFromRoman(@RequestParam(name="roman",defaultValue = "0")String roman){
        roman = roman.toUpperCase();
        if (roman.matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")){
            return RomanNumerals.romanToInteger(roman);
        }else{
            return new RomanNumerals(0,"Not a correct pattern for a roman number");
        }
    }


}
