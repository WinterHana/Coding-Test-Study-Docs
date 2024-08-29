import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GreedyCashBack {

    public static int cashBack(int n) {
        //5230
        //5230%500 = 10 ... 230 몫은 저장하고 230원 으로 다시 반복
        //500 100 50 10
        //400원
        int count = 0;
        int quotient = 0;
        int remainder = 0;

        int[] divisors = {500,100,50,10};
//        int[] divisor2 = new int[]{500,100,50,10};
//        List<Integer> arrayList = new ArrayList<>(Arrays.asList(500,100,50,10));
//       List<Integer> arrayList2 = List.of(500,100,50,10);
//       List<Integer> arrayList3 = new ArrayList<>();
//       Collections.addAll(arrayList3,500,100,50,10);
//        List<Integer> list = Arrays.stream(new int[]{500,100,50,10})
//                .boxed()
//                .toList();


        for (int divisor : divisors) {
            System.out.printf("n : %d <> divisor : %d <> count : %d\n",n,divisor,count);
            quotient = n/divisor;//몫이야
            System.out.printf("quotient : %d\n", quotient);
            n = n - divisor*quotient;//몫*100 빼고 이거 반복
            System.out.printf("new n : %d\n", n);
            count += quotient;
            System.out.printf("new count : %d\n",count);
        }

        return count;

    }

    public static void main(String[] args) {

        cashBack(5230);

    }//End Of Main
}
