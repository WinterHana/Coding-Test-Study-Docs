import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sort(arr);

        System.out.println(String.join(" ", Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new)));

        sc.close();
    }

    static Random rand = new Random(System.currentTimeMillis());

    static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotIdx = rand.nextInt(start, end + 1);
        
        swap(arr, start, pivotIdx);
        pivotIdx = start;

        int pivot = arr[pivotIdx];

        int low = pivotIdx + 1;
        int high = end;

        while (low <= high) {
            while (low <= high && arr[low] >= pivot) {
                low++;
            }
            while (high >= pivotIdx && arr[high] <= pivot) {
                high--;
            }
            if (low > high) {
                swap(arr, high, pivotIdx);
                pivotIdx = high;
            } else {
                swap(arr, low, high);
            }
        }

        quickSort(arr, start, pivotIdx - 1);
        quickSort(arr, pivotIdx + 1, end);
    }

    static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}