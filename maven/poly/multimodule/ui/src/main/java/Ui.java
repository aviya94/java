import java.util.Scanner;

public class Ui {
    Scanner scanner = new Scanner(System.in);
    PolyDerive polyDerive = new PolyDerive();

    public void runUi() {
        double[] poly = getSizeOfPoly();
        Polynomial polynomial = getPolynomial(poly);
        System.out.println(polynomial.toString());
        polynomial = polyDerive.derive(polynomial);
        System.out.println(polynomial.toString());

    }

    private Polynomial getPolynomial(double[] poly) {
        System.out.println("please enter coefficients of polynomial");

        for (int i = 0; i < poly.length; i++) {
            poly[i] = scanner.nextDouble();
        }
        Polynomial polynomial = new Polynomial(poly);
        return polynomial;
    }

    private double[] getSizeOfPoly() {
        System.out.println("What is the size of the polynomial");
        var size = scanner.nextInt();
        double[] poly = new double[size];
        return poly;
    }
}
