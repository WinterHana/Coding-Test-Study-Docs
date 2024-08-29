import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.util.Arrays.binarySearch;

public class BinarySearch {
    //입력값 :: n target array
    //배열의 크기 , 목표값, 배열
/*



11 15
2 4 6 8 10 12 14 16 18 20 22
목표점 < 예측점
11 9
2 4 6 8 10 12 14 16 18 20 22
목표점 < 예측점
11 10
2 4 6 8 10 12 14 16 18 20 22
목표점 == 예측점
11 1
2 4 6 8 10 12 14 16 18 20 22
목표점 < 예측점
11 24
2 4 6 8 10 12 14 16 18 20 22
예측점 < 목표점

11 22
2 4 6 8 10 12 14 16 18 20 22
* */



    //시작점 끝점 중간점을 정해
    //중간점 > 목표 => 끝점 = 중간점 - 1[index]
    //중간점 < 목표 => 시작점 = 중간점 + 1[index]
    //중간점 == 목표 => 중간점 = 시작점
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int target = Integer.parseInt(inputs[1]);
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int result2 = binarySearch2(array,0,n,target);
        System.out.println("내정답"+result2);

        int result = binarySearch(array,0,n,target);
        System.out.println("자바정답"+result);
    }//End Of Main

    public static int binarySearch2(int[] array, int startP, int endP ,int target){
        endP = endP - 1;//exclusive하게 쓰자.
        int insertP = 0;
        while(startP <= endP) {
            insertP = (startP + endP) / 2;
            System.out.printf("수행전 :: startP :: %d, endP :: %d, insertP :: %d, target :: %d\n",startP,endP,insertP,target);
            if (array[insertP] == target) {
                System.out.println("예측점 == 목표점 이므로");
                System.out.printf("수행후 :: startP :: %d, endP :: %d, target :: %d\n\n",startP,endP,target);
                return insertP;
            } else if (array[insertP] < target) {
                System.out.println("예측점 < 목표점 이므로");
                startP = insertP + 1;
            } else {
                System.out.println("목표점 < 예측점 이므로");
                endP = insertP - 1;
            }
            System.out.printf("수행후 :: startP :: %d, endP :: %d, target :: %d\n\n",startP,endP,target);
        }//End of While

        return -startP -1;//절댓값하고 +1하면 같은 값 나오는게 목적임.//수학적 증명은 대가리 깨짐
        //target이 배열에 없으면 반드시 startP와 endP가 같아지는 순간이 온다.

        //만약 target이 배열min보다 작으면 -(0)-1 = -1 리턴해야지 startP=0, insertP=0, endP=-1로 마무리, 이때 정답위치는 0이다.
        //만약 target이 첫중간점보다 크면 -(len+1) - 1 = -len - 2리턴해야지 endP=len, insertP=len, startP=len+1, 이때 정답위치는 len+1이다.
        //만약 target이 첫중간점보다 작으면 -(len+1) - 1 = -len - 2리턴해야지 endP=len, insertP=len, startP=len+1, 이때 정답위치는 len+1이다.
        //만약 target이 배열min,max사이라면 -(정답위치) - 1 = -정답위치-1리턴해야지 endP=정답위치-1, insertP=정답위치-1,정답위치, startP=정답위치

        //startP는 언제나 target값과 같거나, target값보다 1만큼 더 크다.
        //서로 0 0 일때를 제외하면 startP가 언제나 1만큼 크다는 걸 알 수 있음.
        //서로 0 0 일때를 제외하면 startP = insertP + 1로 언제나 if문이 끝난다.
        //타겟값이 배열에 존재하면 startP는 그 값의 위치를 가르킨다.

        //SIBA 그냥 4가지 case 다 돌려보니까 startP가 언제나 정답위치임.
        //그 이유는? SIBA
        //먼저 처음 if문은 예측점 == 목표점인데 이때는 startP=insertP=endP이고, 이거 자체가 언제나 삽입위치이다. 그래서 이 경우에 startP가 정답위치인게 증명됐다.
        //정답위치는 마지막 else-if, else문에 따라 2가지 case로 구분된다
        //왜냐? 모든 케이스가 startP :: K endP :: K+1 인 경우를 거치기 때문이다. 그 이후부터 다른 형태는 딱 2가지로 일반화할 수 있다는게 보인다.
        //target이 배열max보다 크면 마지막이 예측점 < 목표점으로 끝난다. 이게 case 1.
        // 이때 언제나 startP=len, 정답위치=len이므로 startP는 이때 정답위치인게 증명됐다.
        //그 외의 경우 case2에는 전부 마지막 반복문이 목표점 < 예측점으로 끝난다는게 확인된다.
        //이때 startP :: K+1 endP :: K이란거는 (교차했다는거는) 무조건 target이 arr[K]과 arr[K+1] 사이의 값이라는 거다.
        //arr[K]와 arr[K+1]사이의 값인 target은 K+1이 삽입위치가 된다.
        //이건 target값이 배열min보다 작은 경우도 마찬가지로 적용된다.
        //target값이 index -1과 0사이에 들어가야하는데 그럼 arr[0]에 들어가야함. 이때 startP=0임.
    }//End of binarySearch

}