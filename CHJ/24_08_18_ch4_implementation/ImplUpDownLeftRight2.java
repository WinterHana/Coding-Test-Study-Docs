import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ImplUpDownLeftRight2 {

    private static BufferedReader bufferedReader;

    public static void main(String[] args) throws Exception{

        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        ArrayList<String> plans
                = Arrays.stream((bufferedReader.readLine().split(" ")))
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(N);
        System.out.println(plans);

//        int x = 1, y = 1;
        int[] position = {1, 1};

//        int[] dx = {0, 0, -1, 1};
//        int[] dy = {-1, 1, 0, 0};
        int[][] directions = {
                {0, -1},
                {0, 1},
                {-1, 0},
                {1, 0}
        };

        String[] moveTypes = {"L", "R", "U", "D"};

        for (String plan : plans) {

            for (int i = 0; i < moveTypes.length; i++) {
                if (plan.equals(moveTypes[i])) {
//                    int nx = x + dx[i];
//                    int ny = y + dy[i];
//                    int nx = x + directions[i][0];
//                    int ny = x + directions[i][1];
                    int[] nextPosition = {
                            position[0] + directions[i][0],
                            position[1] + directions[i][1]
                    };

                    if (nextPosition[0] < 1 || nextPosition[1] < 1 ||
                            nextPosition[0] > N || nextPosition[1] > N) {
                        continue;
                    }

                    position[0] = nextPosition[0];
                    position[1] = nextPosition[1];
                }
            }//End of For

        }

//        System.out.println(x + "   " + y);
        System.out.println(Arrays.toString(position));

        bufferedReader.close();


    }//End Of Main
}