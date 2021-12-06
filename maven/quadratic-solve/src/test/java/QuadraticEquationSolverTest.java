import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuadraticEquationSolverTest {
    QuadraticEquationSolver quadraticEquationSolver;

    @BeforeEach
    void setUp() {
        quadraticEquationSolver = new QuadraticEquationSolver();
    }

    @Test
    void calc() {
        var res = quadraticEquationSolver.calc(4, 5, 6);
        assertNull(res);
    }

    @Test
    void calc2() {
        var res = quadraticEquationSolver.calc(2, 4, 2);
        assertEquals(1, res.length);
        assertEquals(-1, res[0]);

    }

    @Test
    void calc3() {
        var res = quadraticEquationSolver.calc(1, 4, 3);
        assertEquals(-1, res[0]);
        assertEquals(-3, res[1]);

    }
}