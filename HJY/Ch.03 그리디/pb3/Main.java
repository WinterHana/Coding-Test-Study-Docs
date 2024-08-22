import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //숫자 입력 받기
        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;

        for(; n>=k;) {
            //n이 k로 나눠 떨어지는 값 찾기
            int cal = (n/k)*k;
            
            result +=(n-cal);
            n = cal;

            result +=1;
            n /= k;
        }
        result += (n-1);
        System.out.println(result);
    }
}