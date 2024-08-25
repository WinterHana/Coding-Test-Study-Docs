import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Map<Integer, String> map = new HashMap<>();
        List<Integer> arr = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();

            map.put(score, name);
            arr.add(score);
        }

        

        Collections.sort(arr);

        for (Integer s : arr) {
            System.out.print(map.get(s) + " ");
        }

        sc.close();
    }
}