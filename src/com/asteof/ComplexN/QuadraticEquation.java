package com.asteof.ComplexN;
import com.asteof.Regexps;

import java.util.Scanner;

public class QuadraticEquation {

    public void SolveEquation(int a, int b, int c) {

        double discriminant = Math.pow(b, 2) - (4 * a * c);
        double root1; //equation roots
        double root2;

        if (discriminant > 0) {
            root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Roots are real:\nx1 = " + root1
                    + "\nx2 = " + root2 + "\n");
        } else if (discriminant == 0) {
            root1 = root2 = -(double) b / (2 * a);
            System.out.println("Roots are equal:\n x1 = x2 = " + root2 + "\n");
        } else {
            double real = -(double) b / (2 * a);
            double img = Math.sqrt(-discriminant) / (2 * a);
            ComplexNumber n = new ComplexNumber(real, img);
            System.out.println("Roots are complex:\n \u00B1(" + n.toString()+")\n");
        }
    }

    public void EquationMenu() {
        Scanner input = new Scanner(System.in);
        Regexps reg = new Regexps();
        String inputStr;
        System.out.println("The equation has a standard form\n ax^2 + bx + c = 0\n" +
                "where a, b, c are coefficients. \nNow input coefficient 'a':");
        try {
        while (true) {
            inputStr = input.nextLine();
            if (reg.RegEquation(inputStr)) {
                if(Integer.parseInt(inputStr) != 0)
                {break;}
                else {System.out.println("The 'a' coefficient cannot be 0.");}
            }
            else {System.out.println("Input only digits 1-9 and minus for negative value:");}
        }
        int a = Integer.parseInt(inputStr);

        System.out.println("Input coefficient 'b':");
        while (true) {
            inputStr = input.nextLine();
            if (reg.RegEquation(inputStr)) {break;}
            else {System.out.println("Input only digits and minus for negative value:");}
        }
        int b = Integer.parseInt(inputStr);

        System.out.println("Input coefficient 'c':");
        while (true) {
            inputStr = input.nextLine();
            if (reg.RegEquation(inputStr)) {break;}
            else {System.out.println("Input only digits and minus for negative value:");}
        }
        int c = Integer.parseInt(inputStr);;

            SolveEquation(a, b, c);  }
        catch (Exception ex) {System.out.println("Error invalid entry. Error text message:\n" + ex.getMessage());}
    }
}
