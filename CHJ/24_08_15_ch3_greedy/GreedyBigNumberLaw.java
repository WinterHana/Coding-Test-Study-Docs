import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreedyBigNumberLaw {

    public static void main(String[] args) throws IOException {

        /*
        [4, 5, 3, 19, 20, 20]
        M번 더해
        가장 큰 수
        같은 인덱스 연속 K번까지 가능
        2, 4, 5, 4, 6
        M , K = 8 , 3
        6 + 6 + 6 + 5 + 6 + 6 + 6 + 5
        인덱스만이 유니크함을 결정

        결국작은수필요없고 컬렉션중에 가장큰거 2개 택
        배열크기 N <> 숫자가더해지는횟수 M <> 연속가능수 K
        */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays
                .stream((bufferedReader.readLine()).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = inputs[0];
        int m = inputs[1];
        int k = inputs[2];

        int[] array = Arrays
                .stream((bufferedReader.readLine()).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        int maxValue = 0;
        int maxIndex = 0;
//2,5,7
        for (int i = 0; i < array.length; i++) {
            if(maxValue != Math.max(maxValue,array[i])){
                maxIndex = i;
            }
            maxValue = Math.max(maxValue,array[i]);
        }//End of For

        List<Integer> tempList = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if(i == maxIndex) {
                continue;
            }
            tempList.add(array[i]);
        }//End of For

        int secondValue = tempList.stream().max(Integer::compareTo).orElseThrow();

        System.out.printf("maxValue maxIndex:: %d %d <> secondValue :: %d <> N M K :: %d %d %d <> \n"
        ,maxValue,maxIndex,secondValue,n,m,k);

        int sum = 0;
        int currentIterationNum = 0;

        for (int i = 1; i <= m; i++) {
            if(currentIterationNum < k) {
                sum += maxValue;
                currentIterationNum++;
            } else {
                currentIterationNum=0;
                sum += secondValue;
            }
            System.out.printf("current sum :: %d \n",sum);
        }//End of For

        System.out.println("두구두구두구 정답은..." + sum + " 입니다.");
    }//End Of Main
}
