public class Main {

    public static void main(String[] args){

        ArrExercisess a=new ArrExercisess();
        int[][] arr={ {1,2,3},{4,5,6},{7,8,9}};
        int[] arr2={ 5,2,6,1,10,11,2,9,1,2};
        a.replaceWithClosestGreaterValue(arr2);
        System.out.println(a.integerExistsInPerfectMatrix(arr,5));
}

}
