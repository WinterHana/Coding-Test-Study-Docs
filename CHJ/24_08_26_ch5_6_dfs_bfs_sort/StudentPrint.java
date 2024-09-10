import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StudentPrint {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader
                =new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        String[] names = new String[n];
        int[] nums = new int[n];

        Map<Integer,String> map = new HashMap<>();
        Integer key = null;
        String value = null;

        for (int i = 0; i < n; i++) {
            for (String elem : bufferedReader.readLine().split(" ")) {
                try {
                    key = Integer.parseInt(elem);
                    nums[i] = Integer.parseInt(elem);
                } catch (Exception e) {
                    value = elem;
                }
            }
            map.put(key,value);
        }//End of For

//        System.out.println(map.toString());

        Arrays.sort(nums);

        int j = 0;
        for (int i : nums) {
            names[j] = map.get(i);
            j++;
        }
        System.out.println(Arrays.toString(names));


        /*
        * 숫자끼리만 모았어. 그러면 정렬 해버리면 사람순서는 알 수가 없게 돼.
        * Arrays.sort를 이용해야대 그래야 시간초과안나
        * 홍길동과 95를 연결해야대 map을 만들어야대
        * */

    }//End Of Main
}
