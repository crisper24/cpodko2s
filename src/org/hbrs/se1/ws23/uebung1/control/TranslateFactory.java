package org.hbrs.se1.ws23.uebung1.control;

public class TranslateFactory {

    public Translator createTranslator(){
        return new GermanTranslator();
    }
}