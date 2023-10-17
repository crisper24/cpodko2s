package org.hbrs.se1.ws23.uebung1.control;

import java.util.HashMap;
import java.util.Map;

public class GermanTranslator implements Translator {

    public String date = "Okt/2023"; // Default-Wert
    private Map<Integer, String> numberMap;

    public GermanTranslator() {
        // Initialisieren einer Map mit den Uebersetzungen
        numberMap = new HashMap<>();
        numberMap.put(1, "eins");
        numberMap.put(2, "zwei");
        numberMap.put(3, "drei");
        numberMap.put(4, "vier");
        numberMap.put(5, "fünf");
        numberMap.put(6, "sechs");
        numberMap.put(7, "sieben");
        numberMap.put(8, "acht");
        numberMap.put(9, "neun");
        numberMap.put(10, "zehn");
    }

    /**
     * Methode zur Übersetzung einer Zahl in eine String-Repraesentation
     */
    public String translateNumber(int number) {
        // [ihr Source Code aus Übung 1-2]
        if (number >= 1 && number <= 10) {
            return numberMap.get(number);
        } else {
            // Erstellung der Fehlernachricht
            String errorMessage = "Übersetzung der Zahl " + number + " nicht möglich (Version: "+version+")";
            return errorMessage;
        }
    }

    /**
     * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
     */
    public void printInfo() {
        System.out.println("GermanTranslator v1.9, erzeugt am " + this.date);
    }

    /**
     * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: Monat/Jahr (Beispiel: "Okt/2022"))
     * Das Datum sollte system-intern durch eine Control-Klasse gesetzt werden und nicht von externen View-Klassen
     */
    public void setDate(String date) {
        this.date = date;
    }

}
