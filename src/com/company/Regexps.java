package com.company;

import java.util.regex.*;

public class Regexps {
    public boolean Reg(String S) {
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(S);
        return m.matches();
    }

    public boolean RegNumber(String S) {
        Pattern p = Pattern.compile("[A-Za-z0-9]{1,10}");
        Matcher m = p.matcher(S);
        return m.matches();
    }

    public boolean RegBase(String S) {
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(S);
        return m.matches();
    }

    public boolean RegComplex(String S) {
        Pattern p = Pattern.compile("-?\\d*\\.?\\d+");
        Matcher m = p.matcher(S);
        return m.matches();
    }

    public boolean RegEquation(String S) {
        Pattern p = Pattern.compile("-?[0-9]{1,10}");
        Matcher m = p.matcher(S);
        return m.matches();
    }
}
