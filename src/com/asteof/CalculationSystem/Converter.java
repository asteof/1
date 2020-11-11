package com.asteof.CalculationSystem;

public class Converter {

    public String ConvertToBase(String str, int BaseFrom, int BaseTo) {
        try {
            return Integer.toString(Integer.parseInt(str, BaseFrom), BaseTo);
        } catch (Exception ex) {
            return "Error invalid entry. Error message text:\n" + ex;
        }
    }

}
