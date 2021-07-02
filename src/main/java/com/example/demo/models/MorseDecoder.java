package com.example.demo.models;

import java.util.Hashtable;
import java.util.Set;

public class MorseDecoder{
    private String words;
    private String result;

    public MorseDecoder(String words, String result) {
        this.words = words;
        this.result = result;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public static Hashtable<String, String> getEquals() {
        Hashtable<String, String> equivalencias = new Hashtable<>();
        equivalencias.put("A", ".-");
        equivalencias.put("B", "-...");
        equivalencias.put("C", "-.-.");
        equivalencias.put("CH", "----");
        equivalencias.put("D", "-..");
        equivalencias.put("E", ".");
        equivalencias.put("F", "..-.");
        equivalencias.put("G", "--.");
        equivalencias.put("H", "....");
        equivalencias.put("I", "..");
        equivalencias.put("J", ".---");
        equivalencias.put("K", "-.-");
        equivalencias.put("L", ".-..");
        equivalencias.put("M", "--");
        equivalencias.put("N", "-.");
        equivalencias.put("Ñ", "--.--");
        equivalencias.put("O", "---");
        equivalencias.put("P", ".--.");
        equivalencias.put("Q", "--.-");
        equivalencias.put("R", ".-.");
        equivalencias.put("S", "...");
        equivalencias.put("T", "-");
        equivalencias.put("U", "..-");
        equivalencias.put("V", "...-");
        equivalencias.put("W", ".--");
        equivalencias.put("X", "-..-");
        equivalencias.put("Y", "-.--");
        equivalencias.put("Z", "--..");
        equivalencias.put("0", "-----");
        equivalencias.put("1", ".----");
        equivalencias.put("2", "..---");
        equivalencias.put("3", "...--");
        equivalencias.put("4", "....-");
        equivalencias.put("5", ".....");
        equivalencias.put("6", "-....");
        equivalencias.put("7", "--...");
        equivalencias.put("8", "---..");
        equivalencias.put("9", "----.");
        equivalencias.put(".", ".-.-.-");
        equivalencias.put(",", "--..--");
        equivalencias.put(":", "---...");
        equivalencias.put("?", "..--..");
        equivalencias.put("'", ".----.");
        equivalencias.put("-", "-....-");
        equivalencias.put("/", "-..-.");
        equivalencias.put("\"", ".-..-.");
        equivalencias.put("@", ".--.-.");
        equivalencias.put("=", "-...-");
        equivalencias.put("!", "−.−.−−");
        return equivalencias;
    }

    public static String asciiAMorse(String ascii) {
        Hashtable<String, String> equals = getEquals();
        return equals.getOrDefault(ascii, "");
    }

    public static String morseAAscii(String morseBuscado) {
        Hashtable<String, String> equals = getEquals();
        Set<String> claves = equals.keySet();
        // La clave es la letra ASCII
        for (String clave : claves) {
            String morse = equals.get(clave);
            if (morse.equals(morseBuscado)) {
                return clave;
            }
        }
        return "";
    }

    public static String morseCoder(String word) {
        StringBuilder coder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            String upperCaseChart = String.valueOf(word.charAt(i)).toUpperCase();
            String equals = asciiAMorse(upperCaseChart);
            coder
                    .append(equals)
                    .append(" ");
        }
        return coder.toString();
    }

    public static String decoder(String morseCode) {
        StringBuilder decode = new StringBuilder();

        String[] morse = morseCode.split(" ");

        for (String morseActual : morse) {
            String equals = morseAAscii(morseActual);
            decode.append(equals);
        }
        return decode.toString();
    }
}
