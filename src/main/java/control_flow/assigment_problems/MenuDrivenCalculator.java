package control_flow.assigment_problems;

public class MenuDrivenCalculator {

    void calculate(double a, double b, char operator) {
        switch (operator) {
            case '+':
                System.out.println("Result: " + (a + b));
                break;
            case '-':
                System.out.println("Result: " + (a - b));
                break;
            case '*':
                System.out.println("Result: " + (a * b));
                break;
            case '/':
                if (b == 0) {
                    System.out.println("Cannot divide by zero");
                } else {
                    System.out.println("Result: " + (a / b));
                }
                break;
            default:
                System.out.println("Invalid operator");
                break;
        }
    }

    public static void main(String[] args) {
        MenuDrivenCalculator calculator = new MenuDrivenCalculator();
        calculator.calculate(10, 4, '+');
        calculator.calculate(10, 0, '/');
        calculator.calculate(10, 4, '%');
    }
}
