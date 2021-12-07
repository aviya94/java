import java.util.Arrays;

public class Polynomial {
    private double[] poly;

    public Polynomial(double... poly) {
        this.poly = poly;
    }

    public double[] getPoly() {
        return poly;
    }

    public void addPoly(Polynomial polynomial) {
        int size;
        double[] newPoly;

        if (polynomial.poly.length > this.poly.length) {
            size = polynomial.poly.length;
            newPoly = new double[polynomial.poly.length];

        } else {
            size = poly.length;
            newPoly = new double[poly.length];
        }

        for (int i = 0; i < size; i++) {
            if (i >= polynomial.poly.length) {
                newPoly[i] = poly[i];
            } else if (i >= poly.length) {
                newPoly[i] = polynomial.poly[i];
            } else {

                newPoly[i] = (poly[i] + polynomial.poly[i]);
            }
        }
        poly = newPoly;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, strong = poly.length - 1; i < poly.length - 1; i++, strong--) {
            sb.append(poly[i] + "x^" + strong + "+");
        }
        sb.append(poly[poly.length - 1]);

        return String.valueOf(sb);
    }
}
