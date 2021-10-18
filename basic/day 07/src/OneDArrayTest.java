
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OneDArrayTest {

    private ArrayViewer arrayViewer;

    @Test
    void indexInArr() {
        int[] arr = {1, 5, 7, 8, 10, 11};
        arrayViewer = new ArrayViewer(arr);
        int result = arrayViewer.getValueAt(2);
        int index = arr[2];

        assertEquals(result, index);
    }

    @Test
    void IndexOutOfArr() {
        int[] arr = {1};
        boolean thrown = false;

        arrayViewer = new ArrayViewer(arr);

        try {
            int result = arrayViewer.getValueAt(2);

        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    @Test
    void firstIndex() {
        int[] arr = {1, 5, 7, 8, 10, 11};
        arrayViewer = new ArrayViewer(arr);
        int result = arrayViewer.getValueAt(0);
        int index = arr[0];

        assertEquals(result, index);
    }

    @Test
    void lastIndex() {
        int[] arr = {1, 5, 7, 8, 10, 11};
        arrayViewer = new ArrayViewer(arr);
        int result = arrayViewer.getValueAt(arr.length - 1);
        int index = arr[arr.length - 1];

        assertEquals(result, index);
    }

    @Test
    void getLastIndex() {
        int[] arr = {1, 5, 7, 8, 10, 11};
        arrayViewer = new ArrayViewer(arr);
        int result = arrayViewer.getLastIndex();
        int index = arr[arr.length - 1];

        assertEquals(result, index);
    }

    @Test
    void getFirstIndex() {
        int[] arr = {1, 5, 7, 8, 10, 11};
        arrayViewer = new ArrayViewer(arr);
        int result = arrayViewer.getFirstIndex();
        int index = arr[0];

        assertEquals(result, index);
    }
}
