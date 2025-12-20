package honestcalculator;

import java.util.Scanner;

public class HonestCalculator {
    private final static String[] messages = {"Enter an equation",
                            "Do you even know what numbers are? Stay focused!",
                            "Yes ... an interesting math operation. You've slept through all classes, haven't you?",
                            "Yeah... division by zero. Smart move...",
                            "Do you want to store the result? (y / n):",
                            "Do you want to continue calculations? (y / n):",
                            " ... lazy",
                            " ... very lazy",
                            " ... very, very lazy",
                            "You are",
                            "Are you sure? It is only one digit! (y / n)",
                            "Don't be silly! It's just one number! Add to the memory? (y / n)",
                            "Last chance! Do you really want to embarrass yourself? (y / n)"};

    private double memory;
    private final Scanner scanner;

    public HonestCalculator() {
        memory = 0;
        scanner = new Scanner(System.in);
    }

    public double getMemory() {
        return memory;
    }

    public void storeResult(double result) {
        if (isOneDigit(result)) {
            int msgIndex = 10;
            String answer = "";
            while (msgIndex <= 12) {
                printMessage(msgIndex);
                answer = scanner.nextLine();
                if ("y".equals(answer)) {
                    msgIndex++;
                } else if ("n".equals(answer)) {
                    return;
                }
            }
        }

        memory = result;
    }

    public void printMessage(int index) {
        System.out.println(messages[index]);
    }

    public static boolean isOneDigit(double v) {
        return (v > -10 && v < 10 && v % (int) v == 0);
    }

    public static void check(double x, double y, String oper) {
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
