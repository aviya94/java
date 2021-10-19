
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ThreeDArrayTest {

    private ArrayViewer arrayViewer;

    @Test
    void indexInArr() {
        int[][][] arr = {{{1, 5, 7}, {2, 6, 3}, {1, 6, 9}},
                {{1, 5, 7}, {2, 6, 3}, {1, 6, 9}}};
        arrayViewer = new ArrayViewer(arr);
        int result = arrayViewer.getValueAt(6);
        int index = arr[0][2][0];

        assertEquals(result, index);
    }

    @Test
    void IndexOutOfArr() {
        int[][][] arr = {{{1}, {2}, {3}}, {{4}, {5}, {6}}};
        boolean thrown = false;
        arrayViewer = new ArrayViewer(arr);

        try {
            int result = arrayViewer.getValueAt(6);

        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    @Test
    void firstIndex() {
        int[][][] arr = {{{1, 5, 7}, {2, 6, 3}, {1, 6, 9}},
                {{1, 5, 7}, {2, 6, 3}, {1, 6, 9}}};
        arrayViewer = new ArrayViewer(arr);
        int result = arrayViewer.getValueAt(0);
        int index = arr[0][0][0];

        assertEquals(result, index);
    }

    @Test
    void lastIndex() {
        int[][][] arr = {{{1, 5, 7}, {2, 6, 3}, {1, 6, 9}},
                {{1, 5, 7}, {2, 6, 3}, {1, 6, 9}}};
        arrayViewer = new ArrayViewer(arr);
        int result = arrayViewer.getValueAt(arr.length * arr[0].length * arr[0][0].length - 1);
        int index = arr[arr.length - 1][arr[0].length - 1][arr[0][0].length - 1];

        assertEquals(result, index);
    }

    @Test
    void getLastIndex() {
        int[][][] arr = {{{1, 5, 7}, {2, 6, 3}, {1, 6, 9}},
                {{1, 5, 7}, {2, 6, 3}, {1, 6, 9}}};
        arrayViewer = new ArrayViewer(arr);
        int result = arrayViewer.getLastIndex();
        int index = arr[arr.length - 1][arr[0].length - 1][arr[0][0].length - 1];

        assertEquals(result, index);
    }

    @Test
    void getFirstIndex() {
        int[][][] arr = {{{1, 5, 7}, {2, 6, 3}, {1, 6, 9}},
                {{1, 5, 7}, {2, 6, 3}, {1, 6, 9}}};
        arrayViewer = new ArrayViewer(arr);
        int result = arrayViewer.getFirstIndex();
        int index = arr[0][0][0];

        assertEquals(result, index);
    }

@Test
    void setValueAt() {
        int[][][] arr = {{{1, 5, 7}, {2, 6, 3}, {1, 6, 9}},
                {{1, 5, 7}, {2, 6, 3}, {1, 6, 9}}};
        arrayViewer = new ArrayViewer(arr);
        arrayViewer.setValueAt(5,5);
        int index = 4;
        int result=arr[0][1][2];

        assertEquals(result, index);
    }
}


