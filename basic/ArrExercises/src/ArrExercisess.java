import java.util.Arrays;

public class ArrExercisess {

    public int sum(int[] arr) {
        int SumArr = 0;

        for (int e : arr) {
            {
                SumArr += e;
            }
        }
        return SumArr;
    }

    public int Sum(int[][] mat) {

        int SumElementsMatrix = 0;

        if (mat == null) {
            throw new IllegalArgumentException("matrix is null");
        }

        for (int i = 0; i < mat.length; i++) {
            if (mat[i] != null) {
                SumElementsMatrix += sum(mat[i]);
            }
        }
        return SumElementsMatrix;
    }//1

    public boolean integerExistsInMatrix(int[][] mat, int integerToFind) {
        boolean isExists = false;

        if (mat == null) {
            throw new IllegalArgumentException("matrix is null");
        }

        for (int i = 0; i < mat.length; i++) {
            if (mat[i] != null) {
                isExists = binarySearchInArr(mat[i], integerToFind);
            }
        }
        return isExists;
    }//2

    public boolean binarySearchInArr(int[] arr, int integerToFind) {

        int endSearch = arr.length-1;
        int startSearch = 0;
        int mid;

        while (startSearch <= endSearch) {
            mid= startSearch+(endSearch-startSearch)/2;
            if (arr[mid] == integerToFind) {
                return true;
            } else if (arr[mid] > integerToFind) {
                endSearch = mid-1;
            } else   {
                startSearch = mid+1;
            }
        }
        return false;
    }

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


        public int[][] creatMagicSquare(int num) {

            int[][] magic_square = new int[num][num];

            int row_num = num - 1;
            int col_num = num / 2;
            magic_square[row_num][col_num] = 1;

            for (int i = 2; i <= num * num; i++) {
                if (magic_square[(row_num + 1) % num][(col_num + 1) % num] == 0) {
                    row_num = (row_num + 1) % num;
                    col_num = (col_num + 1) % num;
                } else {
                    row_num = (row_num - 1 + num) % num;
                }
                magic_square[row_num][col_num] = i;
            }
            return magic_square;
        }



    ///4
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

    public void reateDiagonalArray(int rows, int cols) {
        int jump = 2;
        int n = 2;
        int jumpRow = 0;
        int j;
        int s = 1;
        int[][] mat = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {

                if (i == 0 && j == 0) {
                    mat[i][j] = 1;
                } else if (j == 0 && i != 0) {
                    mat[i][j] = mat[i - 1][j] + jump - 2;
                } else {
                    mat[i][j] = mat[i][j - 1] + n;
                    if (i == 0 || j != cols - s) {
                        n++;
                    } else {
                        n--;
                        s--;
                    }
                }
            }
            jump++;
            n = jump;
        }
        printMatrix(mat);
    }

    public void ReplaceWithNextMax(int[] arr) {

        int NextMax=arr[arr.length-1];
        int indexArr;
        for(int i=arr.length-2;i>=0;i--)
        {
            arr[i]=NextMax;
            indexArr=arr[i];
            if(NextMax<indexArr)
            {
                NextMax=indexArr;
            }
        }

    }//7
}
