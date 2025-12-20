package honestcalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        HonestCalculator calculator = new HonestCalculator();
        String calc, oper, xString, yString, userChoice;
        String[] parts;
        float x, y;
        float result;

        while (true) {
            calculator.printMessage(0);
            calc = keyboard.nextLine();

            if ("".equals(calc)) {
                continue;
            }

            parts = calc.split(" ");
            xString = parts[0];
            oper = parts[1];
            yString = parts[2];

            if ("M".equals(xString)) {
                xString = Double.toString(calculator.getMemory());
            }

            if ("M".equals(yString)) {
                yString = Double.toString(calculator.getMemory());
            }

            if (notANumber(xString) || notANumber(yString)) {
                calculator.printMessage(1);
                continue;
            } else if (!oper.matches("[-+*/]")) {
                calculator.printMessage(2);
                continue;
            } else {
                x = Float.parseFloat(xString);
                y = Float.parseFloat(yString);

                HonestCalculator.check(x, y, oper);

                if ("/".equals(oper) && y == 0) {
                    calculator.printMessage(3);
                    continue;
                } else {
                    result = performOperation(x, y, oper);
                    System.out.println(performOperation(x, y, oper));
                }
            }

            while (true) {
                calculator.printMessage(4);
                userChoice = keyboard.nextLine();

                if ("y".equals(userChoice)) {
                    calculator.storeResult(result);
                    break;
                } else if ("n".equals(userChoice)) {
                    break;
                }
            }

            userChoice = "";
            do {
                calculator.printMessage(5);
                userChoice = keyboard.nextLine();
            } while (!"y".equals(userChoice) && !"n".equals(userChoice));

            if ("n".equals(userChoice)) {
                break;
            }

        }
    }

    public static boolean notANumber(String str) {
        return !str.matches("-?\\d+(\\.\\d+)?");
    }

    public static float performOperation(float x, float y, String oper) {
        float result = 0;
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