import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrExercisessTest {
    private ArrExercisess arr;

    @BeforeEach
    void SetUp(){
        arr = new ArrExercisess();
    }

    @Test
    void binarySearchInMatrix() {

        int mat[][]={{1,2,3},{4,5,6,7},{8,9,10}};
        int a = 4;

        final boolean result = arr.binarySearchInMatrix(mat,a);
        assertEquals(true, result);
    }

    @Test
    void binarySearchInZeroMatrix() {

        int mat[][]={{0,0,0},{0,0,0,0},{0,0,0}};
        int a = 4;

        final boolean result = arr.binarySearchInMatrix(mat,a);
        assertEquals(false, result);
    }

}
