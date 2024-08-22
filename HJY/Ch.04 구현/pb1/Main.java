import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        //현재 위치 입력 받기
        String location = sc.nextLine();

        //ASCII 코드 활용
        int row = location.charAt(1) - '0';
        int column = location.charAt(0) - 'a'+1;

        //나이트가 이동할 수 있는 경우의 수
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        //이동 가능 여부 확인
        int count = 0;
        for(int i = 0 ; i < 8 ; i++) {
            int nextRow = row + dx[i];
            int nextColumn = column + dy[i];

            if(nextRow >=1 && nextRow <=8 && nextColumn >=1 && nextColumn <=8) {
                count +=1;
            }
        }       
        System.out.println(count);
    }
}