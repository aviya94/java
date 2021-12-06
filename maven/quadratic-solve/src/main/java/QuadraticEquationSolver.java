
public class QuadraticEquationSolver {

    public double[] calc(int a, int b, int c) {
        double calc= Math.pow(b,2) - 4 * a * c;

        if(calc<0)
        {
            return null;
        }
        double sqrt=Math.sqrt(calc);
        double r0=(-b+sqrt)/(2*a);
        double r1=(-b-sqrt)/(2*a);

        if(r0==r1)
        {
            double []result=new double[]{r0};
            return  result;
        }
        double []result=new double[]{r0,r1};
        return result;
    }
}
