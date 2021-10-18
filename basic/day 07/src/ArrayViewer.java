import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayViewer {
    private ArrayList<Integer> length;
    private Object dimArray;
    private int dimArrLength;

    public ArrayViewer(Object array) {
        length = creatArrayOfDim(array);
        dimArray = array;
        dimArrLength = getLength();
    }

    private ArrayList<Integer> creatArrayOfDim(Object array) {
        ArrayList<Integer> lengthArray = new ArrayList<Integer>();

        while (isArray(array)) {
            lengthArray.add(Array.getLength(array));
            array = Array.get(array, 0);
        }

        return lengthArray;
    }

    private int getLength() {
        int sumOfElement = 1;

        for (int e : length) {
            sumOfElement *= e;
        }

        return sumOfElement;
    }

    public static boolean isArray(Object objecy) {
        return objecy.getClass().isArray();

    }

    public int getValueAt(int value) {

        Object array = dimArray;
        int arrLlength = dimArrLength;
        int currntIndex;

        for (int i = 0; i < length.size(); i++) {

            arrLlength /= length.get(i);
            currntIndex = value / arrLlength;
            value = value % arrLlength;
            array = Array.get(array, currntIndex);
        }

        return (int) array;
    }

    public int getLastIndex() {
        return getValueAt(dimArrLength - 1);
    }

    public int getFirstIndex() {
        return getValueAt(0);
    }

    /*
    public void setValueAt(int value) {
        Object array = dimArray;
        int arrLlength = dimArrLength;
        ArrayList<Integer> indexArray=new ArrayList<Integer>();

        for (int i = 0; i < length.size(); i++) {

            arrLlength /= length.get(i);
            int currntIndex = value / arrLlength;
            value = value % arrLlength;
            array = Array.get(array, currntIndex);
            indexArray.add(currntIndex);
        }

    }

 */

}

