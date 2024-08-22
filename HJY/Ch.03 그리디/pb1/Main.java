import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //n, m, k 입력 받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        //n개의 수 입력 받기
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();            
        }

        Arrays.sort(arr);
        int first = arr[n-1];
        int second = arr[n-2];

        int sum = (m/(k+1))*k;
        sum += m % (k+1);

        int result = 0;
        result += sum*first;
        result += (m-sum)*second;

        System.out.println(result);
    }
}