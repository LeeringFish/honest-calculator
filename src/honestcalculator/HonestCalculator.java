package honestcalculator;

public class HonestCalculator {
    private final static String[] msgs = {"Enter an equation",
                            "Do you even know what numbers are? Stay focused!",
                            "Yes ... an interesting math operation. You've slept through all classes, haven't you?",
                            "Yeah... division by zero. Smart move..."};

    private double memory;

    public HonestCalculator() {
        memory = 0.0;
    }

    public void storeResult(double num) {
        memory = num;
    }

    public void printMessage(int index) {
        System.out.println(msgs[index]);
    }
}
