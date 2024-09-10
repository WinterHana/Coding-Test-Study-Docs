import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.util.Arrays.binarySearch;

public class FIndParts {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(System.in));
        //가게의 부품 수
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] mart = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(mart);
//        System.out.println(Arrays.toString(mart));
        //손놈의 부품 수
        int m = Integer.parseInt(bufferedReader.readLine());
        int[] customer = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        System.out.println(Arrays.toString(customer));
        for (int part : customer) {
//            int isExisted = binarySearch(mart,0,n,part);
            int isExisted = binarySearch2(mart,0,n,part);
            if( isExisted > 0 ) {
                System.out.print("no ");
            } else {
                System.out.print("yes ");
            }
        }
    }//End Of Main

    public static int binarySearch2(int[] array, int startP, int endP, int target){
        endP = endP - 1;//exclusive
        int insertP = 0;
        while(startP <= endP) {

            insertP = (startP + endP)/2;

            if(target == array[insertP]) {
                return insertP;
            } else if (target < array[insertP]) {
                endP = insertP - 1;
            } else {
                startP = insertP + 1;
            }

        }

        return -insertP - 1;

    }
}

//부품 N개 있어.
//부품마다 고유번호가 잇음
// M 개 종류 부품을 대량구매할게요
// M 종류 모두 확인해서 견적서 작성해야함
// 가게안에 부품이 모두 있는지 확인해야함
// N = 5
/*
 * 손님은 부품을 하나씩만 구매함
 * M = 3
 * [5, 7, 9] 부품 > no yes yes
입력값 내꺼 손님요구사항 손님꺼는 정렬 안해도 돼.
* 5가 있는지 찾아야대 7이 있는지 찾아야대 9가 있는지 찾아야대
* 정렬하는데 nlogn이야. 100000*log100000이므로 대략 33*10^7이야
* 거기에다가 이진탐색은 M * logN이 들어.
* 그러므로  (N+M)(logN)이야. 66*10^7 정도니까 10^8인 1초보다 ok
* log100000
5
8 3 7 9 2
3
5 7 9




 * */

