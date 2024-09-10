import java.util.Scanner;

public class MakeOne2 {

    //1의 정답부터 30001의 정답까지 저장
    static int[] d = new int[30001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println(execute(x));
        scanner.close();
    }

    //1부터 정답을 계속 구하는거야
    //먼저 부분합이 모여서 전체합이 되는지 봐.

    //기저조건
    //결과사용
    //재귀호출
    //결과저장
    public static int execute(int x) {
        // 이미 계산된 경우 그 값을 반환
        if (x == 1) {
            return 0;  // 1의 최소 연산 횟수는 0
        }
        // 결과 사용
        if (d[x] != 0) {
            return d[x];
        }

        int result = Integer.MAX_VALUE;

        //26의 최소횟수 = 13의 최소연산횟수 + 1 or 25의 최소연산횟수 + 1
        //30의 최소횟수는
        //15의 최소연산횟수 + 1, 10의 최소연산횟수 + 1, 6의 최소연산횟수 + 1

        if (x % 2 == 0) {
            result = execute(x / 2) + 1;
        }
        if (x % 3 == 0) {
            result = Math.min(result, execute(x / 3) + 1);
        }
        if (x % 5 == 0) {
            result = Math.min(result, execute(x / 5) + 1);
        }

        if (result == Integer.MAX_VALUE) {
            result = execute(x - 1) + 1;
        }

        // 결과 저장
        d[x] = result;
        return result;
    }
}
