import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PolynomialTest {
    private Polynomial polynomial;

    @BeforeEach
    void setUp() {
        polynomial = new Polynomial(4, 3, 2, 8);
    }

    @Test
    void addPoly() {
        Polynomial addPoly = new Polynomial(2, 4, 3);
        polynomial.addPoly(addPoly);
        System.out.println(polynomial.toString());
    }

}
