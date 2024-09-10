public class MergeSortArray {

    // 배열을 정렬하는 병합 정렬 함수
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            // 배열을 두 부분으로 나눕니다.
            int middle = (left + right) / 2;

            // 왼쪽 부분을 재귀적으로 정렬합니다.
            mergeSort(array, left, middle);

            // 오른쪽 부분을 재귀적으로 정렬합니다.
            mergeSort(array, middle + 1, right);

            // 두 정렬된 부분을 합칩니다.
            merge(array, left, middle, right);
        }
    }

    // 두 정렬된 부분 배열을 합치는 함수
    public static void merge(int[] array, int left, int middle, int right) {
        // 두 부분 배열의 크기를 구합니다.
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // 임시 배열을 만듭니다.
        int[] L = new int[n1];
        int[] R = new int[n2];

        // 데이터를 임시 배열에 복사합니다.
        for (int i = 0; i < n1; ++i) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = array[middle + 1 + j];
        }

        // 임시 배열을 합칩니다.
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        // 남은 요소들을 복사합니다.
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    // 메인 함수
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        System.out.println("정렬 전 배열:");
        printArray(array);

        mergeSort(array, 0, array.length - 1);

        System.out.println("\n정렬 후 배열:");
        printArray(array);
    }

    // 배열을 출력하는 함수
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
