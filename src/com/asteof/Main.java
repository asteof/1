package com.asteof;
import java.util.Scanner;
import com.asteof.CalculationSystem.*;
import com.asteof.ComplexN.ComplexMenu;
import com.asteof.ComplexN.QuadraticEquation;

public class Main {

    public static void main(String[] args) {

        ConvertMenu convertMenu = new ConvertMenu();
        ComplexMenu complexMenu = new ComplexMenu();
        QuadraticEquation quadraticEquation = new QuadraticEquation();
        Regexps reg = new Regexps();
        Scanner input = new Scanner(System.in);
        String InterfaceChoice;
        System.out.println("Main menu ^_^\n");
        while (true) {
            System.out.println("Choose option: \n\n" +
                "1 - Convert numbers from one base to another\n" +
                "2 - Basic operations on complex numbers\n" +
                "3 - Quadratic equations with complex roots\n" +
                "0 - Quit program");

            while (true) {
                InterfaceChoice = input.nextLine();
                if (reg.Reg(InterfaceChoice)) {
                    break;
                }
                else System.out.println("Invalid entry. Input only digits");
            }

            byte res = Byte.parseByte(InterfaceChoice);
            if (res == 1) {
                convertMenu.Conversion();
            }
            else if (res == 2) {
                complexMenu.complexNumbersMenu();
            }
            else if (res == 3) {
                quadraticEquation.EquationMenu();
            }
            else if (res == 0) break;
            else System.out.println("Wrong input");
        }

    }
}

