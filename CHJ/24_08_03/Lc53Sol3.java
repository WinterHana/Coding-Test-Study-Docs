class Lc53Sol3 {
    public int maxSubArray(int[] nums) {
        return maxSubArrayHelper(nums, 0, nums.length - 1);
    }

    private int maxSubArrayHelper(int[] nums, int left, int right) {
        // Base case: 배열에 하나의 원소만 있을 경우
        if (left == right) {
            return nums[left];
        }

        int mid = (left + right) / 2;

        // 좌측 하위 배열의 최대 부분 배열 합
        int leftMax = maxSubArrayHelper(nums, left, mid);

        // 우측 하위 배열의 최대 부분 배열 합
        int rightMax = maxSubArrayHelper(nums, mid + 1, right);

        // 중간을 가로지르는 최대 부분 배열 합
        int crossMax = crossSum(nums, left, right, mid);

        // 세 가지 경우 중 최대값 반환
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private int crossSum(int[] nums, int left, int right, int mid) {
        // 왼쪽 부분 배열에서의 최대 합
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }

        // 오른쪽 부분 배열에서의 최대 합
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }

        // 왼쪽 최대 합과 오른쪽 최대 합을 더한 값 반환
        return leftSum + rightSum;
    }
}
