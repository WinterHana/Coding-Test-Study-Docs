import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[][] homeworks = new int[n][];
        for (int i = 0; i < n; i++) {
            homeworks[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(solution(n, homeworks));
        br.close();
    }

    static int solution(int n, int[][] homeworks) {
        PriorityQueue<Homework> pq1 = new PriorityQueue<>((h1, h2) -> {
            int diff = h1.deadline - h2.deadline;
            if (diff == 0) {
                return h2.reward - h1.reward;
            }
            return diff;
        });
        PriorityQueue<Homework> pq2 = new PriorityQueue<>((h1, h2) -> h1.reward - h2.reward);

        for (int i = 0; i < n; i++) {
            Homework homework = new Homework(i, homeworks[i][1], homeworks[i][0]);
            pq1.add(homework);
        }

        int sum = 0;
        while (!pq1.isEmpty()) {
            Homework head = pq1.poll();
            int timeLeft = head.deadline - pq2.size();
            if (timeLeft > 0) {
                sum += head.reward;
                pq2.add(head);
            } else {
                if (head.reward > pq2.peek().reward) {
                    Homework fromPq2 = pq2.poll();
                    sum = sum - fromPq2.reward + head.reward;
                    pq2.add(head);
                }
                // timeLeft = pq2.size() - head.deadline;
                // List<Homework> fromPq2List = new ArrayList<>();
                // int fromPq2Sum = 0;
                // for (int i = 0; i <= timeLeft; i++) {
                //     Homework fromPq2 = pq2.poll();
                //     fromPq2Sum += fromPq2.reward;
                //     fromPq2List.add(fromPq2);
                // }
                // if (head.reward > fromPq2Sum) {
                //     sum = sum - fromPq2Sum + head.reward;
                //     pq2.add(head);
                // }
            }
        }
        return sum;
    }

    static class Homework {
        int number;
        int reward;
        int deadline;

        Homework(int number, int reward, int deadline) {
            this.number = number;
            this.reward = reward;
            this.deadline = deadline;
        }
    }
}
