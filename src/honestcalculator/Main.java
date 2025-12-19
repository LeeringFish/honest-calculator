package honestcalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        String msg0 = "Enter an equation";
        String msg1 = "Do you even know what numbers are? Stay focused!";
        String msg2 = "Yes ... an interesting math operation. You've slept through all classes, haven't you?";
        String msg3 = "Yeah... division by zero. Smart move...";
        String msg4 = "Do you want to store the result? (y / n):";
        String msg5 = "Do you want to continue calculations? (y / n):";
        String calc, oper, xString, yString, userChoice;
        String[] parts;
        float x, y;
        float memory = 0, result;

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

            if ("M".equals(xString)) {
                xString = Float.toString(memory);
            }

            if ("M".equals(yString)) {
                yString = Float.toString(memory);
            }

            if (notANumber(xString) || notANumber(yString)) {
                System.out.println(msg1);
                continue;
            } else if (!oper.matches("[-+*/]")) {
                System.out.println(msg2);
                continue;
            } else {
                x = Float.parseFloat(xString);
                y = Float.parseFloat(yString);

                check(x, y, oper);

                if ("/".equals(oper) && y == 0) {
                    System.out.println(msg3);
                    continue;
                } else {
                    result = performOperation(x, y, oper);
                    System.out.println(performOperation(x, y, oper));
                }
            }

            while (true) {
                System.out.println(msg4);
                userChoice = keyboard.nextLine();

                if ("y".equals(userChoice)) {
                    memory = result;
                    break;
                } else if ("n".equals(userChoice)) {
                    break;
                }
            }

            do {
                System.out.println(msg5);
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

    public static boolean isOneDigit(float v) {
        return (v > -10 && v < 10 && v % (int) v == 0);
    }

    public static void check(float x, float y, String oper) {
        StringBuilder msg = new StringBuilder();
        if (isOneDigit(x) && isOneDigit(y)) {
            msg.append(" ... lazy");
        }

        if ("*".equals(oper) && (x == 1 || y == 1)) {
            msg.append(" ... very lazy");
        }

        if ((x == 0 || y == 0) &&
                ("*".equals(oper) || "+".equals(oper) || "-".equals(oper))) {
            msg.append(" ... very, very lazy");
        }

        if (!msg.toString().isEmpty()) {
            msg.insert(0, "You are");
            System.out.println(msg);
        }

    }



}