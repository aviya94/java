public class PolyDerive {

    public Polynomial derive(Polynomial polynomial) {
        double[] arrPoly = polynomial.getPoly();
        double[] derive = new double[arrPoly.length - 1];
        for (int i = 0, strong = arrPoly.length - 1; i < arrPoly.length - 1; i++, strong--) {
            derive[i] = arrPoly[i] * strong;

        }
        return new Polynomial(derive);
    }
}
