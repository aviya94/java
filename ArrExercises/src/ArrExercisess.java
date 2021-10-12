import java.util.Arrays;

public class ArrExercisess {

    public int SumOfAllIntegerMatrix(int[][] mat) {
        int SumElementsMatrix = 0;

        for (int row = 0; row < mat.length; row++) {

            for (int col = 0; col < mat[row].length; col++) {
                SumElementsMatrix += mat[row][col];
            }

        }
        return SumElementsMatrix;

    }//1

    public boolean integerExistsInMatrix(int[][] mat, int integerToFind) {
        boolean isExists = false;
        for (int row = 0; row < mat.length; row++) {

            for (int col = 0; col < mat[row].length; col++) {
                if (integerToFind == mat[row][col]) {
                    isExists = true;
                    break;
                }
            }

        }
        return isExists;
    }//2

    public boolean isMagicSquare(int[][] mat) {

        int sumOfCol = 0;
        int sumOfFirstCol = 0;
        int sumOfRow = 0;
        int sumOfSlantLeft = 0;
        int sumOfSlantRight = 0;
        int reversRow = mat.length - 1;
        boolean isMagicSquare = true;

        for (int row = 0; row < mat.length; row++) {
            sumOfFirstCol += mat[row][0];
        }

        for (int row = 0; row < mat.length; row++, reversRow--) {
            sumOfSlantLeft += mat[row][row];
            sumOfSlantRight += mat[reversRow][row];

            for (int col = 0; col < mat[row].length; col++) {
                sumOfCol += mat[row][col];
                sumOfRow += mat[col][row];
            }

            if (sumOfCol != sumOfFirstCol && sumOfRow != sumOfFirstCol) {
                isMagicSquare = false;
                break;
            } else {
                sumOfCol = 0;
                sumOfRow = 0;
            }
        }

        if (sumOfSlantLeft != sumOfFirstCol && sumOfSlantRight != sumOfFirstCol) {
            isMagicSquare = false;
        }

        return isMagicSquare;
    }//3

    /*
        public int[][]creatMagicSquare(int size)
        {re

        }

     *///4
    public void printMatrix(int[][] mat) {

        for (int row = 0; row < mat.length; row++) {
            System.out.print("[");

            for (int col = 0; col < mat[row].length; col++) {

                System.out.print(mat[row][col]);
                System.out.print(",");
            }

            System.out.println("]");

        }
    }//5

    public void ReplaceWithNextMax(int[] arr) {

        int[] countersArray;
        int max = arr[0];
        int newMax = 0;
        boolean Replacfe = false;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        countersArray = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            countersArray[arr[i]]++;
        }

        for (int i = 0; i < arr.length; i++) {
            Replacfe = false;

            for (int j = countersArray.length - 1; j >= 0; j--) {
                if (countersArray[j] > 0) {
                    newMax = countersArray[i];
                    countersArray[j]--;
                    Replacfe = true;
                    continue;
                }
            }
            if (arr[i] > newMax && Replacfe == true)
            {

                arr[i] = newMax;
            }
            countersArray[arr[i]]--;

        }

    }//7
}
