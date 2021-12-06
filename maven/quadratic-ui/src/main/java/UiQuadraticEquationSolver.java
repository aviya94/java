import java.util.Scanner;
/**
 * @runUi = scan parameters from user and print the result of quadratic Equation
 * **/
public class UiQuadraticEquationSolver {
    private QuadraticEquationSolver quadraticEquationSolver = new QuadraticEquationSolver();
    private Scanner scanner = new Scanner(System.in);

    /**
     * scan 3 double number and print Quadratic Equation result
     * **/
    public void runUi() {
        System.out.println("enter quadratic equation coefficients");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        printEquation(a, b, c);
        Double[] result = quadraticEquationSolver.calc(a, b, c);

        PrintResult(result);

    }
/**
 * print Quadratic Equation Solver result
 * @param result - result from  quadraticEquationSolver.calc
 * **/
    private void PrintResult(Double[] result) {
        if (result[0] == null && result[1] == null) {
            System.out.println("No roots exist");
        } else {
            for (int i = 0; i < result.length; i++) {
                System.out.println("r" + i + " = " + result[i]);
            }
        }
    }

    private void printEquation(double a, double b, double c) {
        System.out.println(a + "x^2+" + b + "x+" + c);
    }
}
