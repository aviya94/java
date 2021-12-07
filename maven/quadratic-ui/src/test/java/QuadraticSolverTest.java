import org.hamcrest.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class QuadraticSolverTest {
    QuadraticEquationSolver quadraticEquationSolver;

    @BeforeEach
    void setUp() {
        quadraticEquationSolver = new QuadraticEquationSolver();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "4,5,6,null,null",
            "2,4,2,-1,-1",
            "1,4,3,-1,-3"},
            nullValues={"null"})

    void testWithCsvSource(double a, double b, double c, Double r0, Double r1) {
        Double[] res = quadraticEquationSolver.calc(a, b, c);
        assertThat(2,equalTo( res.length));
        assertThat(r0, equalTo(res[0]));
        assertThat(r1, equalTo(res[1]));

    }

}
