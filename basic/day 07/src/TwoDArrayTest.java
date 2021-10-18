
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoDArrayTest {

    private ArrayViewer arrayViewer;

    @Test
    void indexInArr() {
        int[][] arr = {{1, 5, 7, 8, 10, 11}, {2, 6, 3, 2, 11, 15}, {1, 6, 9, 2, 4, 2}};
        arrayViewer = new ArrayViewer(arr);
        int result = arrayViewer.getValueAt(14);
        int index = arr[2][2];

        assertEquals(result, index);

    }

    @Test
    void IndexOutOfArr() {
        int[][] arr = {{1}, {2}, {3}};
        boolean thrown = false;
        arrayViewer = new ArrayViewer(arr);

        try {
            int result = arrayViewer.getValueAt(4);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    @Test
    void firstIndex() {
        int[][] arr = {{1, 5, 7, 8, 10, 11}, {2, 6, 3, 2, 11, 15}, {1, 6, 9, 2, 4, 2}};
        arrayViewer = new ArrayViewer(arr);
        int result = arrayViewer.getValueAt(0);
        int index = arr[0][0];

        assertEquals(result, index);
    }

    @Test
    void lastIndex() {
        int[][] arr = {{1, 5, 7, 8, 10}, {2, 6, 3, 2, 11}, {1, 6, 9, 2, 4}};
        arrayViewer = new ArrayViewer(arr);
        int result = arrayViewer.getValueAt(arr.length * arr[0].length - 1);
        int index = arr[arr.length - 1][arr[0].length - 1];

        assertEquals(result, index);
    }

    @Test
    void getLastIndex() {
        int[][] arr = {{1, 5, 7, 8, 10}, {2, 6, 3, 2, 11}, {1, 6, 9, 2, 4}};
        arrayViewer = new ArrayViewer(arr);
        int result = arrayViewer.getLastIndex();
        int index = arr[arr.length - 1][arr[0].length - 1];

        assertEquals(result, index);
    }

    @Test
    void getFirstIndex() {
        int[][] arr = {{1, 5, 7, 8, 10}, {2, 6, 3, 2, 11}, {1, 6, 9, 2, 4}};
        arrayViewer = new ArrayViewer(arr);
        int result = arrayViewer.getFirstIndex();
        int index = arr[0][0];

        assertEquals(result, index);
    }
}


