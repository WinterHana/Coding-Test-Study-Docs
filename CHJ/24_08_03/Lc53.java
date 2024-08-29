import java.util.Arrays;

public class Lc53 {
    public static int[] maxSubArray(int[] nums) {
        // 초기화
        int maxSoFar = nums[0];
        int currentMax = nums[0];
        int start = 0, end = 0, tempStart = 0;

        // 배열 순회
        for (int i = 1; i < nums.length; i++) {
            //배열을 순회하며 최대 부분집합을 구하는데 있어서 2가지 case가 있음
            //원소 하나로 새로운 부분집합을 만드는게 더 값이 크다.
            // 새로운 부분 배열 시작
            if (nums[i] > currentMax + nums[i]) {
                currentMax = nums[i];
                tempStart = i;
            //그게 아니라면 부분집합에 값을 포함시켜본다.
            // 기존 부분 배열에 추가
            } else {
                currentMax += nums[i];
            }

            //포함시키고보니
            if (currentMax > maxSoFar) {
                maxSoFar = currentMax;
                start = tempStart;
                end = i;
            }
        }

        // 부분 배열 추출
        int[] subArray = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            subArray[i - start] = nums[i];
        }

        return subArray;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] result = maxSubArray(nums);

        // 최대 합 부분 배열 출력
        System.out.print("Subarray with maximum sum: ");
        for (int num : result) {
            System.out.print(num + " ");
        }

        System.out.println();
        System.out.printf("Sum of array elements: %d\n"
                , Arrays.stream(result).sum());

//        int sum = 0;
//        for (int i = 0; i < result.length; i++) {
//            sum += result[i];
//        }//End of For
//        System.out.printf("Sum of array elements: %d\n", sum);
    }
}
