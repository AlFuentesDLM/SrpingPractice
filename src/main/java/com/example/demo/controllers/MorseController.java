package com.example.demo.controllers;

import com.example.demo.models.MorseDecoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/morse")
public class MorseController {
    @GetMapping(path = "/get-morse")
    public MorseDecoder getMorse(@RequestParam(name="words",defaultValue = " ")String words){
        String morse = MorseDecoder.morseCoder(words);
        return  new MorseDecoder(words,morse);
    }
    @GetMapping(path = "/get-words")
    public MorseDecoder getWords(@RequestParam(name="morse",defaultValue = " ") String morse){
        String words = MorseDecoder.decoder(morse);
        return new MorseDecoder(words,morse);
    }
}
