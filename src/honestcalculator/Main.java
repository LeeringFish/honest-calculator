package honestcalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        String msg0 = "Enter an equation";
        String msg1 = "Do you even know what numbers are? Stay focused!";
        String msg2 = "Yes ... an interesting math operation. You've slept through all classes, haven't you?";
        String msg3 = "Yeah... division by zero. Smart move...";
        String calc, oper, xString, yString;
        String[] parts;
        double x, y;

        while (true) {
            System.out.println(msg0);
            calc = keyboard.nextLine();

            if ("".equals(calc)) {
                continue;
            }

            parts = calc.split(" ");
            xString = parts[0];
            oper = parts[1];
            yString = parts[2];

            if (notANumber(xString) || notANumber(yString)) {
                System.out.println(msg1);
            } else if (!oper.matches("[-+*/]")) {
                System.out.println(msg2);
            } else {
                x = Double.parseDouble(xString);
                y = Double.parseDouble(yString);

                if ("/".equals(oper) && y == 0) {
                    System.out.println(msg3);
                } else {
                    System.out.println(performOperation(x, y, oper));
                }
            }
        }
    }

    public static boolean notANumber(String str) {
        return !str.matches("-?\\d+(\\.\\d+)?");
    }

    public static double performOperation(double x, double y, String oper) {
        double result = 0;
        if ("+".equals(oper)) {
            result = x + y;
        } else if ("-".equals(oper)) {
            result = x - y;
        } else if ("*".equals(oper)) {
            result = x * y;
        } else if ("/".equals(oper)) {
            result = x / y;
        }

        return result;
    }

}