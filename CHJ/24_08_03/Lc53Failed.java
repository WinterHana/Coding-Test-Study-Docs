import java.util.ArrayList;

public class Lc53Failed {
    public int maxSubArray(int[] nums){

        ArrayList<Integer> subArr = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            System.out.printf("index :: %d와 그에 따른 value :: %d\n", i, nums[i]);
            //음수면 버려
            if(nums[i] < 0) {
                System.out.println("도움이 안된다.");
            //양수면
            } else {
                int newI = (i == nums.length - 1)
                        ? i
                        : verifyHelpMaximizeAndApplyAndReturnI(i,nums,subArr);
                System.out.printf("인덱스 %d의 값을 %d로 건너뜁니다.\n",i,newI);
                i = newI;
            }
            System.out.printf("subArray :: %s\n",subArr.toString());
        }//End of For

        System.out.println("결과 :: subArray :: "+subArr.toString());

        return subArr
                .stream()
                .mapToInt(Integer::intValue)
                .sum();

    }

    /**
     *
     * @param i
     * @param nums
     * @param subArr
     * @return
     */
    public int verifyHelpMaximizeAndApplyAndReturnI(int indexI, int[] nums, ArrayList<Integer> subArr){

        // indexJ는 반복문 마친 후 음수의 인덱스 값을 의미.
        int indexJ = indexI;
        int particalSum = 0;

        //nums를 반복문을 돌릴거야. 음수가 나오면 그거까지 더하고 멈추기.
        while(indexJ < nums.length){
            particalSum += nums[indexJ];
            System.out.printf("particalSum :: %d\n",particalSum);
            if(nums[indexJ] < 0){
                break;
            }
            indexJ++;
        }

        //도움이 되는 거라면
        if(particalSum > 0) {
            System.out.println("도움이 된다.");
            System.out.printf("indexI :: %d와 indexJ :: %d\n",indexI,indexJ);
            for (int j = indexI; j <= indexJ; j++) {
                subArr.add(nums[j]);
            }//End of For
        } else {
            System.out.println("도움이 안된다");
        }

        return indexJ;

    }

    public static void main(String[] args) {

        int[] arr = {-2,1, -3, 4, -1, 2, 1, -5, 4};

        Lc53Failed lc53Failed = new Lc53Failed();

        System.out.printf("결과 :: sum :: %d", lc53Failed.maxSubArray(arr));


    }//End Of Main
}


//음수면 바로 거르고,
//양수면 다음 음수가 나왔을때 Sum이 음수라면 전체 arr를 버려