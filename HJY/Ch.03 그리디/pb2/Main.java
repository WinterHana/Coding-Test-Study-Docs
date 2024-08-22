import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //행,열 크기 입력 받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;
        
        //행, 열 크기만큼 숫자 입력
        for(int i = 0 ; i < n ; i++) {
            int min = 10000;
            
            for(int j = 0 ; j < m ; j++) {
                int k = sc.nextInt();
                min = Math.min(min, k);
            }
            result = Math.max(result, min);
        }
        System.out.println(result);
    }
}