package honestcalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        String msg0 = "Enter an equation";
        String msg1 = "Do you even know what numbers are? Stay focused!";
        String msg2 = "Yes ... an interesting math operation. You've slept through all classes, haven't you?";
        String calc, x, y, oper;
        String[] parts;

        while (true) {
            System.out.println(msg0);
            calc = keyboard.nextLine();

            if ("".equals(calc)) {
                continue;
            }

            parts = calc.split(" ");
            x = parts[0];
            oper = parts[1];
            y = parts[2];

            if (notANumber(x) || notANumber((y))) {
                System.out.println(msg1);
            } else if (!oper.matches("[-+*/]")) {
                System.out.println(msg2);
            } else {
                break;
            }

        }

    }

    public static boolean notANumber(String str) {
        return !str.matches("-?\\d+(\\.\\d+)?");
    }
}