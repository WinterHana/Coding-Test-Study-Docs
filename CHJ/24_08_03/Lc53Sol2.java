import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc53Sol2 {

    public static int[] maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentMax = nums[0];
        List<Integer> maxSubArrayList = new ArrayList<>(List.of(nums[0]));
        List<Integer> currentSubArrayList = new ArrayList<>(List.of(nums[0]));

        for (int i = 1; i < nums.length; i++) {
            //음수면 버려 그리고 새로 해 줫망한거야.
            if (currentMax < 0) {
                currentMax = nums[i];
                currentSubArrayList.clear();
                currentSubArrayList.add(nums[i]);
            //양수면 일단 넣어봐
            } else {
                currentMax = currentMax + nums[i];
                currentSubArrayList.add(nums[i]);
            }

            //이제 최대라고 생각했던 과거와 비교해.
            if (currentMax > maxSoFar) {
                maxSoFar = currentMax;
                maxSubArrayList.clear();
                maxSubArrayList.addAll(currentSubArrayList);
            }
        }//End of For

        return maxSubArrayList
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] result = maxSubArray(nums);

        System.out.println("arr :: "+Arrays.toString(result));

        System.out.println("sum :: " + Arrays
                .stream(result)
                .sum());
    }//End Of Main
}