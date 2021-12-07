

public class Polynomial {
    private double[] poly;

    public Polynomial(double... poly) {
        int size= 0;
        int i;
        for (i = 0; i < poly.length; i++) {
            if(poly[i]!=0)
            {
                break;
            }
        }

        this.poly = new double[poly.length-i];
        size=0;
        for (int j = i; j <poly.length ; j++) {

                this.poly[size++]=poly[j];
        }
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
        String op;
        for (int i = 0, strong = poly.length - 1; i < poly.length ; i++, strong--) {
            if(poly[i]<0||i==0)
            {
                op="";
            }
            else {
                op="+";
            }
            if(poly[i]!=0) {
                if (i == poly.length - 2) {
                    sb.append(op+poly[i] + "x");
                } else if (i == poly.length - 1) {
                    sb.append(op+poly[i]);
                } else {
                    sb.append(op+poly[i] + "x^" + strong );
                }
            }
        }


        return String.valueOf(sb);
    }
}
