import java.util.Scanner;

public class MakeOneLog {

    // 1의 정답부터 30001의 정답까지 저장
    static int[] d = new int[30001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println("최소 연산 횟수: " + execute(x));
        scanner.close();
    }

    // 재귀 함수
    public static int execute(int x) {
        // 이미 계산된 경우 그 값을 반환
        if (x == 1) {
            System.out.println("x = 1, 최소 연산 횟수 = 0");
            return 0;  // 1의 최소 연산 횟수는 0
        }

        // 결과 사용
        if (d[x] != 0) {
            System.out.println("x = " + x + ", 이미 계산된 값 = " + d[x]);
            return d[x];
        }

        int result = Integer.MAX_VALUE;

        System.out.println("현재 x = " + x);

        // 2로 나누어지는 경우
        if (x % 2 == 0) {
            System.out.println("x = " + x + ", x/2 = " + (x / 2) + "에 대해 재귀 호출");
            result = execute(x / 2) + 1;
            System.out.println("x = " + x + ", x/2 = " + (x / 2) + "의 최소 연산 횟수 + 1 = " + result);
        }

        // 3으로 나누어지는 경우
        if (x % 3 == 0) {
            System.out.println("x = " + x + ", x/3 = " + (x / 3) + "에 대해 재귀 호출");
            int tempResult = execute(x / 3) + 1;
            result = Math.min(result, tempResult);
            System.out.println("x = " + x + ", x/3 = " + (x / 3) + "의 최소 연산 횟수 + 1 = " + tempResult + ", 현재 최소 연산 횟수 = " + result);
        }

        // 5로 나누어지는 경우
        if (x % 5 == 0) {
            System.out.println("x = " + x + ", x/5 = " + (x / 5) + "에 대해 재귀 호출");
            int tempResult = execute(x / 5) + 1;
            result = Math.min(result, tempResult);
            System.out.println("x = " + x + ", x/5 = " + (x / 5) + "의 최소 연산 횟수 + 1 = " + tempResult + ", 현재 최소 연산 횟수 = " + result);
        }

        // 1을 빼는 경우
        if (result == Integer.MAX_VALUE) {
            System.out.println("x = " + x + ", x-1 = " + (x - 1) + "에 대해 재귀 호출");
            result = execute(x - 1) + 1;
            System.out.println("x = " + x + ", x-1 = " + (x - 1) + "의 최소 연산 횟수 + 1 = " + result);
        }

        // 결과 저장
        d[x] = result;
        System.out.println("x = " + x + ", 최종 최소 연산 횟수 = " + result);

        return result;
    }
}
