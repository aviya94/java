import java.util.Scanner;

public class UiQuadraticEquationSolver {
    private QuadraticEquationSolver quadraticEquationSolver = new QuadraticEquationSolver();
    private Scanner scanner = new Scanner(System.in);

    public void runUi() {
        System.out.println("enter quadratic equation coefficients");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        printEquation(a, b, c);
        double[] result = quadraticEquationSolver.calc(a, b, c);

        PrintResult(result);

    }

    private void PrintResult(double[] result) {
        if (result == null) {
            System.out.println("No roots exist");
        } else {
            for (int i = 0; i < result.length; i++) {
                System.out.println("r" + i + " = " + result[i]);
            }
        }
    }

    private void printEquation(int a, int b, int c) {
        System.out.println(a + "x^2+" + b + "x+" + c);
    }
}
