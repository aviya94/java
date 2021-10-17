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
    @Test
    void replaceWithClosestGreaterValue() {

        int[] array={ 5,2,6,1,10,11,2,9,1,2};
        int []result={6,6,10,10,11,-1,9,-1,2,-1};
        arr.replaceWithClosestGreaterValue(array);

            assertArrayEquals(result,array);

    }

    @Test
    void replaceWithClosestGreaterValueInSortedArray() {

        int[] array={1,2,3,4,5,6,7};
        int []result={2,3,4,5,6,7,-1};
        arr.replaceWithClosestGreaterValue(array);

        assertArrayEquals(result,array);

    }

    @Test
    void replaceWithClosestGreaterValueInReverseSortedArray() {

        int[] array= {7,6,5,4,3,2,1};
        int []result={-1,-1,-1,-1,-1,-1,-1};
        arr.replaceWithClosestGreaterValue(array);

        assertArrayEquals(result,array);

    }
}
