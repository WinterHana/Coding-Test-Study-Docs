import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] first = new int[n];
        for (int i = 0; i < n; i++) {
            first[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] second = new int[m];
        for (int j = 0; j < m; j++) {
            second[j] = sc.nextInt();
        }

        String answer = solution(first, second);
        System.out.println(answer);

        sc.close();
    }

    static String solution(int[] first, int[] second) {
        Arrays.sort(first);

        String[] output = new String[second.length];
        for (int i = 0; i < second.length; i++) {
            output[i] = exists(first, second[i])
                    ? "yes"
                    : "no";
        }
        return String.join(" ", output);
    }

    static boolean exists(int[] first, int elem) {
        return binarySearch(first, elem, 0, first.length - 1);
    }

    static boolean binarySearch(int[] arr, int elem, int lower, int upper) {
        if (lower == upper) {
            return arr[lower] == elem;
        }
        int center = (lower + upper) / 2;
        if (arr[center] == elem) {
            return true;
        } else if (arr[center] > elem) {
            return binarySearch(arr, elem, lower, center - 1);
        } else {
            return binarySearch(arr, elem, center + 1, upper);
        }
    }
}