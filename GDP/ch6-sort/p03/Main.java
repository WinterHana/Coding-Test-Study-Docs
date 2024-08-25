import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        int answer = solution(a, b, n, k);
        System.out.println(answer);

        sc.close();
    }

    static int solution(int[] a, int[] b, int n, int k) {
        List<Integer> listA = new ArrayList<>(Arrays.stream(a).mapToObj(Integer::valueOf).toList());
        List<Integer> listB = new ArrayList<>(Arrays.stream(b).mapToObj(Integer::valueOf).toList());

        Collections.sort(listA);
        Collections.sort(listB, (n1, n2) -> n2 - n1);

        for (int i = 0; i < k; i++) {
            int fromA = listA.get(i);
            int fromB = listB.get(i);
            if (fromA < fromB) {
                listA.set(i, fromB);
                listB.set(i, fromA);
            } else {
                break;
            }
        }

        return listA.stream().reduce(0, Integer::sum, Integer::sum);
    }
}