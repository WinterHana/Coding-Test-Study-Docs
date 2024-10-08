import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int l = input[0];
        int u = input[1];

        long answer = solution(l, u);

        System.out.println(answer);
    }

    static long solution(int l, int u) {
        Map<Integer, Long> map = generateMap();

        l--;
        int lNumOfDigits = getNumOfDigits(l);
        long lSum = getDigitSum(l, lNumOfDigits, (int)Math.pow(10, lNumOfDigits - 1), map);

        int uNumOfDigits = getNumOfDigits(u);
        long uSum = getDigitSum(u, uNumOfDigits, (int)Math.pow(10, uNumOfDigits - 1), map);

        return uSum - lSum;
    }

    static Map<Integer, Long> generateMap() {
        long acc = 1;
        int digits = 1;
        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 0L);

        while (acc < 2000000000) {
            long sum = 0;
            for (int i = 0; i <= 9; i++) {
                sum += i * acc + map.get(digits - 1);
            }
            map.put(digits, sum);
            digits++;
            acc *= 10;
        }
        return map;
    }

    static long getDigitSum(int num, int numOfDigits, int acc, Map<Integer, Long> map) {
        if (numOfDigits == 0) {
            return 0L;
        }
        int mostSig = num / acc;
        long sum = 0L;
        for (int i = 0; i <= mostSig - 1; i++) {
            sum += i * acc + map.get(numOfDigits - 1);
        }
        sum += mostSig * (num % acc + 1);
        return sum + getDigitSum(num % acc, numOfDigits - 1, acc / 10, map);
    }

    static int getNumOfDigits(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }
}