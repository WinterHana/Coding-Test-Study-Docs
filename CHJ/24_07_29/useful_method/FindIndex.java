/**
 * FInd a specific value in a Array
 *
 * 배열... 타겟값...
 */
public class FindIndex {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int target = 3;

        int index = findIndex(arr, target);

        if (index != -1) {
            System.out.printf("Target value %d is at index %d.\n",target,index);
        } else {
            System.out.printf("Target value %d is not found.\n", target);
        }
    }//End Of Main

    public static int findIndex(int[] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                return i;
            }
        }//End of For
        return -1;
    }

}