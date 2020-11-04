package CalculationSystem;
import java.util.Scanner;
import com.company.Regexps;

public class ConvertInterface {
    Regexps reg = new Regexps();
    public void Conversion() {
        Calculation calc = new Calculation();
        Scanner input = new Scanner(System.in);
        String inputStr = null;
        int baseFrom, baseTo;
        boolean repeat = true;

        while (repeat) {
            System.out.println("Input number you want to convert:");
            String NumberToConvert;
            while (true) {
                NumberToConvert = input.next();
                if (reg.RegNumber(NumberToConvert)) {break;}
                else if (NumberToConvert.length() >10){ System.out.println("Input 10 digits or latin symbols:");}
                else { System.out.println("Not acceptable entry. Input only digits [0-9] or latin symbols [A-Z]:");}
            }
            System.out.println("Input base in which you want to convert your number (BASE_TO):");
            baseTo = InputBase(inputStr);
            System.out.println("Input base in which your number is (BASE_FROM):");
            baseFrom = InputBase(inputStr);
            System.out.println("Result of converting:");
            System.out.println(calc.ConvertToBase(NumberToConvert, baseFrom, baseTo));
            System.out.println("\nInput 1 to retry, input 0 to return to main menu");

        while (true) {
            inputStr = input.next();
            if (inputStr.equals("1") || inputStr.equals("0")) break;
            else System.out.println("Input only digits 0 or 1: ");
        }
        int res = Integer.parseInt(inputStr);
        if (res == 1) {repeat= true;}
        else if (res == 0) {repeat= false;}

        }
    }

    public int InputBase (String Str){
        Scanner scan = new Scanner(System.in);
        int base;
        while (true) {
            Str = scan.next();
            if (reg.RegBase(Str)) {
                base = Integer.parseInt(Str);
                if (base>1 && base<=36)
                break;
                else {System.out.println("Value out of bounds. Input only digits from 2 to 36:"); }
            }
            else {System.out.println("Error invalid entry. Input only digits from 2 to 36:"); }
        }
        return base;
    }
}
