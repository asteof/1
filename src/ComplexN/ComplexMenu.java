package ComplexN;
import com.company.Regexps;

import java.util.Scanner;

public class ComplexMenu {
    Scanner input = new Scanner(System.in);
    Regexps reg = new Regexps();
    public void complexNumbersMenu() {
        String inputStr;
        boolean repeat = true;

        while (repeat) {
            System.out.println("Chose action:\n" +
                    "\n1 - Add 2 complex numbers" +
                    "\n2 - Subtract 2 complex numbers" +
                    "\n3 - Multiply 2 complex numbers" +
                    "\n4 - Divide 2 complex numbers" +
                    "\n5 - Scale a complex number" +
                    "\n0 - Return to main menu");
            String itemS;
            while (true) {
                itemS = input.nextLine();
                if (reg.Reg(itemS)) {break;}
                else {System.out.println("Input only digits:");}
            }
            int item = Integer.parseInt(itemS);
            switch (item) {
                case 1:
                    AddTwoComplexNumbers();
                    break;
                case 2:
                    SubtractTwoComplexNumbers();
                   break;
                case 3:
                    MultiplyTwoComplexNumbers();
                    break;
                case 4:
                    DivideTwoComplexNumbers();
                    break;
                case 5:
                    ScaleComplexNumber();
                    break;
                case 0:
                    System.out.println("Quitting...");
                    break;
                default:
                    System.out.println("Input digits to select item. Values between 0-5");
            }

            System.out.println("\nInput 1 to return to complex numbers menu, input 0 to return to main menu");
            while (true) {
                inputStr = input.next();
                if (inputStr.equals("0") || inputStr.equals("1")) break;
                else System.out.println("Input only digits 0 or 1: ");
            }
            int res = Integer.parseInt(inputStr);
            if (res == 1) {repeat = true;}
            else if (res == 0) {repeat = false;}
        }
    }

    public ComplexNumber CreateComplexNumber() {
        System.out.println("Input the real part of the complex number");
        String in;
        while (true) {
            in = input.nextLine();
            if (reg.RegComplex(in)) {break;}
            else {System.out.println("Input only digits and minus for negative value:");}
        }
        int re = Integer.parseInt(in);

        System.out.println("Input the imaginary part of the complex number: ");
        while (true) {
            in = input.nextLine();
            if (reg.RegComplex(in)) {break;}
            else {System.out.println("Input only digits and minus for negative value:");}
        }
        int img = Integer.parseInt(in);
        ComplexNumber n = new ComplexNumber(re, img);
        System.out.println("Your number is:\n" + ShowComplexNumber(n) + "\n");
        return n;
    }
    public String ShowComplexNumber (ComplexNumber n) {
        return n.toString();
    }

    public void AddTwoComplexNumbers() {
        ComplexNumber n1 = CreateComplexNumber();
        ComplexNumber n2 = CreateComplexNumber();
        ComplexNumber newComplex = ComplexNumber.Add(n1, n2);
        System.out.println("Sum:\n(" +
                ShowComplexNumber(n1) + ") + (" + ShowComplexNumber(n2) + ") = " + newComplex.toString());
    }
    public void SubtractTwoComplexNumbers() {
        ComplexNumber n1 = CreateComplexNumber();
        ComplexNumber n2 = CreateComplexNumber();
        ComplexNumber newComplex = ComplexNumber.Subtract(n1, n2);
        System.out.println("Difference:\n(" +
                n1.toString() + ") - (" + n2.toString() + ") = " + newComplex.toString());
    }
    public void MultiplyTwoComplexNumbers() {
        ComplexNumber n1 = CreateComplexNumber();
        ComplexNumber n2 = CreateComplexNumber();
        ComplexNumber newComplex = ComplexNumber.Multiply(n1, n2);
        System.out.println("Multiplication:\n(" +
                n1.toString() + ") * (" + n2.toString() + ") = " + newComplex.toString());
    }

    public void DivideTwoComplexNumbers() {
        ComplexNumber n1 = CreateComplexNumber();
        ComplexNumber n2 = CreateComplexNumber();
        ComplexNumber newComplex = ComplexNumber.Divide(n1, n2);
        System.out.println("Division:\n(" + n1.toString() + ")\n" +
                "--------------------- = " + newComplex.toString() +
                "\n(" + n2.toString() + ")" );
    }

    public void ScaleComplexNumber () {
        ComplexNumber n = CreateComplexNumber();
        System.out.println("Input scale coefficient:");
        String in;
        while (true) {
            in = input.nextLine();
            if (reg.RegComplex(in)) {break;}
            else {System.out.println("Input only digits:");}
        }
        double c = Double.parseDouble(in);
        ComplexNumber newComplex = ComplexNumber.Scale(c, n);
        System.out.println("Your number is:\n" + ShowComplexNumber(newComplex) + "\n");
    }
}
