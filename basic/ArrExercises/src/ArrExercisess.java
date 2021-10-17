import java.util.Stack;

public class ArrExercisess {

    public int sum(int[] arr) {
        int SumArr = 0;

        for (int e : arr) {
            {
                SumArr += e;
            }
        }

        return SumArr;
    }//1

    public int sum(int[][] mat) {

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

    public boolean integerExistsInPerfectMatrix(int[][] mat, int integerToFind) {

        if (mat == null) {
            throw new IllegalArgumentException("matrix is null");
        }

        return binarySearchInMatrix(mat,integerToFind);

    }//2

    public boolean binarySearchInMatrix(int[][] mat, int integerToFind)//2
    {
        MultiDimArrayAsArrayView matInArr=new MultiDimArrayAsArrayView(mat);
        int endSearch = matInArr.getLastIndex();
        int startSearch = 0;
        int mid;

        while (startSearch <= endSearch) {
            mid = startSearch + (endSearch - startSearch) / 2;

            if (matInArr.getIndexArray(mid) == integerToFind) {
                return true;
            }
            else if (matInArr.getIndexArray(mid) > integerToFind) {
                endSearch = mid - 1;
            }
            else {
                startSearch = mid + 1;
            }
        }
        return false;
       /* while (startSearch <= endSearch) {
            mid = startSearch + (endSearch - startSearch) / 2;
            row = mat[mid];
            if(row[0]<=integerToFind&&integerToFind<=row[row.length-1]) {
                return binarySearchInArr(row, integerToFind);
            }
            else if (mat[mid][0] > integerToFind) {
                endSearch = mid - 1;
            }
            else if(mat[mid][mat.length-1]<integerToFind ){
                startSearch = mid + 1;
            }

        }//2
        return false;

        */
    }

    public boolean binarySearchInArr(int[] arr, int integerToFind) {

        int endSearch = arr.length - 1;
        int startSearch = 0;
        int mid;

        while (startSearch <= endSearch) {
            mid = startSearch + (endSearch - startSearch) / 2;

            if (arr[mid] == integerToFind) {
                return true;
            } else if (arr[mid] > integerToFind) {
                endSearch = mid - 1;
            } else {
                startSearch = mid + 1;
            }
        }

        return false;
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

        for (int i = 0; i < mat.length; i++, reversRow--) {
            sumOfSlantLeft += mat[i][i];
            sumOfSlantRight += mat[reversRow][i];

            for (int j = 0; j < mat[i].length; j++) {
                sumOfCol += mat[i][j];
                sumOfRow += mat[j][i];
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
        if (isMagicSquare == true) {
            if ((mat.length * (mat.length + 1)) / 2 == sum(mat)) {
                return true;
            }
        }
        return false;
    }//3

    public int[][] creatMagicSquare(int num) {


        int[][] magicSquare = new int[num][num];

        int rowNum = num - 1;
        int colNum = num / 2;
        magicSquare[rowNum][colNum] = 1;

        for (int i = 2; i <= num * num; i++) {

            if (magicSquare[(rowNum + 1) % num][(colNum + 1) % num] == 0) {
                rowNum = (rowNum + 1) % num;
                colNum = (colNum + 1) % num;
            } else {
                rowNum = (rowNum - 1 + num) % num;
            }

            magicSquare[rowNum][colNum] = i;
        }

        return magicSquare;
    }//4

    public void print(int[][] mat) {

        for (int row = 0; row < mat.length; row++) {
            System.out.print("[");

            print(mat[row]);

            System.out.println("]");

        }
    }//5

    public void print(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(",");
        }
    }//5

    public void createDiagonalArray(int rows, int cols) {

        int[][] mat = new int[rows][cols];
        int indexToFill = createUpperDiagonalArray(mat);
        createLowerDiagonalArray(mat, indexToFill);
        print(mat);

    }//6

    public void createLowerDiagonalArray(int[][] mat, int indexToFill) {

        for (int i = 1; i <= mat[0].length - 1; i++) {
            int upperIndex = mat.length - 1;
            int rightIndex = i;

            indexToFill = fillDiagonalArray(mat, upperIndex, rightIndex, indexToFill);
        }
    }//6

    public int createUpperDiagonalArray(int[][] mat) {
        int indexToFill = 0;

        for (int i = 0; i < mat.length; i++) {
            int upperIndex = i;
            int rightIndex = 0;

            indexToFill = fillDiagonalArray(mat, upperIndex, rightIndex, indexToFill);
        }
        return indexToFill;
    }//6

    public int fillDiagonalArray(int[][] mat, int upperIndex, int rightIndex, int indexToFill)//6
    {
        while (upperIndex >= 0 && rightIndex < mat[upperIndex].length) {
            mat[upperIndex--][rightIndex++] = indexToFill++;
        }

        return indexToFill;
    }

    public int[] ReplaceWithNextMax(int[] arr) {

        int NextMax = arr[arr.length - 1];
        int indexArr;

        for (int i = arr.length - 2; i >= 0; i--) {
            arr[i] = NextMax;
            indexArr = arr[i];
            if (NextMax < indexArr) {
                NextMax = indexArr;
            }
        }
        return arr;

    }//7
    /*
    public void replaceWithClosestGreaterValue(int arr[])//8
    {
        int []arrSmallNumber=new int[arr.length];


        for(int i=0 ; i < arr.length ; i++)
        {
            arrSmallNumber[i]=arr[i];

            for(int j = 0 ; j < i ; j++)
            {

                if(arrSmallNumber[j]==arr[j]) {
                    if (arr[i] > arrSmallNumber[j]) {
                        arr[j] = arr[i];

                    }
                }

            }
        }
        for(int i=0 ; i < arr.length ; i++){

            if(arrSmallNumber[i]==arr[i])
            {
                arr[i]=-1;
            }
        }
        print(arr);

    }

     */
    public void replaceWithClosestGreaterValue(int arr[])//8
    {
        Stack<Integer>stack =new Stack<Integer>();
        stack.add(arr[0]);

        for(int i=1 ; i < arr.length ; i++) {

            if (arr[i] > arr[i - 1]) {
                changeSmallerNumberInStackfromIndex(stack,arr,i);
            }
            stack.add(arr[i]);
        }
        setNumberInUnchangedIndex(-1,arr,stack);


    }
    public void setNumberInUnchangedIndex(int numberToSet,int []arr,Stack<Integer> stack){
        while (!stack.empty())
        {
            for(int i =arr.length-1;i>=0;i--)
            {

                if(arr[i]==stack.peek())
                {
                arr[i]=-1;
                stack.pop();
                break;
                }
            }
        }
       // print(arr);
    }

    public void changeSmallerNumberInStackfromIndex(Stack<Integer> stack,int []arr,int indexInArr)
    {
        int stackSize=stack.size();

       for (int i=0;i<stackSize;i++)
       {
            if(arr[indexInArr]>stack.peek())
            {
            arr[indexInArr-(i+1)]=arr[indexInArr];
            stack.pop();
            }

        }
    }
    /*
    public void replaceWithClosestGreaterValue(int arr[]) {//8
        boolean isChanged = false;

        for (int i = 0; i < arr.length - 1; i++) {
            if (i != arr.length - 1) {
                for (int j = i + 1; i < arr.length - 1; j++) {

                    if (arr[j] > arr[i]) {
                        arr[i] = arr[j];
                        isChanged = true;
                        break;
                    }
                }

                if (isChanged == false) {
                    arr[i] = -1;
                } else {
                    isChanged = false;
                }

            }
        }
        arr[arr.length - 1] = -1;
        print(arr);
    }




int[]copyArr=arr;
    int maxIndex=arr[arr.length-1];
    int nextIndex;

    for(int i=arr.length-2;i>0;i--)
    {
        if(copyArr[i]<maxIndex){
            arr[i]=maxIndex;
        }
        else {
            arr[i] = -1;
        }

        if(copyArr[i-1]<copyArr[i]) {
            maxIndex=copyArr[i];
        }

    }
    arr[arr.length-1]=-1;
        print(arr);
    }


    }

       */
}
