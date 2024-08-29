import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Integer[] a = new Integer[n];
        for(int i = 0 ; i < n ; i++) {
            a[i] = sc.nextInt();
        }

        Integer[] b = new Integer[n];
        for(int j = 0 ; j < n ; j++) {
            b[j] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        for (int i = 0; i < k ; i++) {
            if(a[i] < b[i]) {
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            }
            else break;
        }

        long result = 0;
        for (int i = 0; i < n ; i++) {
            result += a[i];
        }
        System.out.println(result);
    }
}