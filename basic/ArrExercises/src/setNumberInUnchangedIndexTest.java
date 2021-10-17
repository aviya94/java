import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class setNumberInUnchangedIndexTest {

    private ArrExercisess arr;

    @BeforeEach
    void SetUp(){
        arr = new ArrExercisess();
    }
    @Test
    void UpAndDownArray() {

        int[] array={ 5,2,6,1,10,11,2,9,1,2};
        int []result={6,6,10,10,11,-1,9,-1,2,-1};
        arr.replaceWithClosestGreaterValue(array);

        assertArrayEquals(result,array);

    }
    @Test
    void UpAndDownArray2() {

        int[] array= {7,6,5,1,2,4,3,10,9,8,7,2,4,9,5};
        int []result={10,10,10,2,4,10,10,-1,-1,9,9,4,9,-1,-1};
        arr.replaceWithClosestGreaterValue(array);

        assertArrayEquals(result,array);
    }

    @Test
    void InSortedArray() {

        int[] array={1,2,3,4,5,6,7};
        int []result={2,3,4,5,6,7,-1};
        arr.replaceWithClosestGreaterValue(array);

        assertArrayEquals(result,array);

    }

    @Test
    void ReverseSortedArray() {

        int[] array= {7,6,5,4,3,2,1};
        int []result={-1,-1,-1,-1,-1,-1,-1};
        arr.replaceWithClosestGreaterValue(array);

        assertArrayEquals(result,array);

    }

    @Test
    void nullArray() {

        int[] array=null;
        arr.replaceWithClosestGreaterValue(array);

        assertArrayEquals(null,array);

    }

    void lengthArrayIs1() {

        int[] array= {7};
        int []result={-1};
        arr.replaceWithClosestGreaterValue(array);

        assertArrayEquals(result,array);

    }
}
