/**
 * Quadratic Equation Solver
 * @calc = calculate the Quadratic Equation
 * **/
public class QuadraticEquationSolver {
    /**
     *
     * @param a=coefficients of x^2
     * @param b=coefficients of x^1
     * @param c=coefficients x^0
     * @return= result of Quadratic Equation
     */
    public Double[] calc(double a, double b, double c) {
        double calc= Math.pow(b,2) - 4 * a * c;
        Double []result=new Double[2];

        if(calc>=0) {
            double sqrt = Math.sqrt(calc);
            Double r0 = (-b + sqrt) / (2 * a);
            Double r1 = (-b - sqrt) / (2 * a);
            result[0]=r0;
            result[1]=r1;
        }


        return result;
    }
}
