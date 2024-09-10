import java.util.Arrays;

public class MergeSort {

    //배열을 정렬하는 병합 정렬 함수
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            //배열을 두 부분으로 나눕니다.
            int middle = (left + right) / 2;

            //왼쪽 부분을 재귀적으로 정렬합니다.
            mergeSort(array, left, middle);

            //오른쪽 부분을 재귀적으로 정렬합니다.
            mergeSort(array, middle + 1, right);

            //두 정렬된 부분을 합칩니다.
            merge(array, left, middle, right);

        }
    }

    //두 정렬된 부분 배열을 합치는 함수
    public static void merge(int[] array, int left, int middle, int right) {
        //두 부분 배열의 크기를 구합니다. 빼고나서 1을 더해야 해.
        int n1 = middle - left + 1; // middle - left + (1)
        int n2 = right - middle; // right - (middle + 1) + 1

        //임시배열을 만듭니다
        int[] L = new int[n1];
        int[] R = new int[n2];

        //데이터를 임시 배열에 복사합니다.
        //End of For
        // 1 : 원본배열 2 : 복사시작위치(인덱스)
        // 3 : 대상배열 4 : 복사받을 시작위치
        // 5 : 복사할 요소의 개수
//       System.arraycopy(sourceArray, srcPos, destArray, destPos, length);
        System.arraycopy(array, left, L, 0, n1);
//        for (int i = 0; i < n1; i++) {
//            L[i] = array[left + i];
//        }//End of For
        System.arraycopy(array, middle + 1, R, 0, n2);
//        for (int j = 0; j < n2; j++) {
//            R[j] = array[middle + 1 + j];
//        }//End of For


        //TODO :: 어쩌고 해야함 지금 당장 해결
        //임시 배열을 합칩니다.
        // i : L 배열의 현재 인덱스를 가르킴
        // j : R 배열의 현재 인덱스를 가르킴
        // k : 병합결과를 저장할 원본 배열의 현재 인덱스를 가르킴
        // L = {11, 12 ,13} R = {5, 6, 7}
        // 11과 5를 비교한 후, array : [5]
        // 작은 값이 나온(R) 배열의 인덱스를 증가시킨다.
        // 11과 6을 비교한 후, array : [5, 6]
        // 11과 7을 비교한 후, array : [5, 6, 7]
        // 이제 왼쪽 or 오른쪽 배열이 완성되며 반복문이 멈춘다.
        int i = 0, j = 0; int k = left;

        while(i < n1 && j < n2) { // {0, i<N, i++} ==> N번 반복이야. 마지막 i값은 N-1이지.
            //윈본배열에 더 작은걸 넣는다.
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
        // i < n1이 성립하면 left에 요소가 남은 거다. 그걸 다 원본 배열에 추가해야된다.
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        // j < n2가 성립하면 right에 요소가 남은 거다. 그걸 다 원본 배열에 추가해야된다.
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }

    }//merge

    // 메인 함수
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        System.out.println("정렬 전 배열:");
        printArray(array);

        mergeSort(array, 0, array.length - 1);

        System.out.println("\n정렬 후 배열:");
        printArray(array);
    }

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}