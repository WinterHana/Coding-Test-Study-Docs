import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        Integer[] arr = new Integer[n];

        for(int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (int j = 0 ; j < n ; j++) {
            System.out.print(arr[j] + " ");
        }
    }
}