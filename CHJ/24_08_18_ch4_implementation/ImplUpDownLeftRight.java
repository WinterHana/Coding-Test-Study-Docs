import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ImplUpDownLeftRight {

    //넘어가면 무시!
    //공간의 크기 N
    //계획서
    //left right up down




    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        String[] plan = (bufferedReader.readLine()).split(" ");

        //제한이 N,N까지야


        int[] humanPosition = {1,1};
        //x,y left -1, 0 right 1, 0 up 0,1 down 0,-1
        //x,y left  0, -1   right 0, 1 up -1 0 down 1 0
        System.out.println(N);
        System.out.println(Arrays.toString(plan));

        for (String direction : plan) {
            switch (direction) {
                case "U" :
                    if(humanPosition[0] > 1) {
                        humanPosition[0] = humanPosition[0] - 1;
                    }
                    break;
                case "D" :
                    if(humanPosition[0] < N) {
                        humanPosition[0] = humanPosition[0] + 1;
                    }
                    break;
                case "R" :
                    if(humanPosition[1] < N) {
                        humanPosition[1] = humanPosition[1] + 1;
                    }
                    break;
                case "L" :
                    if(humanPosition[1] > 1) {
                        humanPosition[1] = humanPosition[1] - 1;
                    }
                default:
                    break;
            }
            System.out.println(Arrays.toString(humanPosition));
        }

        System.out.println(Arrays.toString(humanPosition));


    }//End Of Main

}
