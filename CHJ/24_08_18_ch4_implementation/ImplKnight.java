import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ImplKnight {

    public static int function(String input) {
        String[] knightCoord = input.split("");
        knightCoord[0] = String.valueOf(knightCoord[0].charAt(0) - 97 + 1);


        //이동이란건 가로 2칸 세로 1칸 세로 2칸 가로 1칸
        //+-2 +-1
        //+-1 +-2 이렇게 두종류라는 거군! 그리고 값이 만약 음수면 break;

        //1,1이야 그러면 이동은 8종류가 있어.

        int[] movedCoord = new int[2];
        int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};


//        int count = 0;
//        for (int i = 0; i <= 7; i++) {
//            movedCoord[0] = Integer.parseInt(knightCoord[0]) + dx[i];
//
//            if(movedCoord[0] < 1 || movedCoord[0] > 8 ) {
//                continue;
//            }
//
//            movedCoord[1] = Integer.parseInt(knightCoord[1]) + dy[i];
//
//            if(movedCoord[1] < 1 || movedCoord[1] > 8) {
//                continue;
//            }
//
//            count++;
//
//        }//End of For

        int[] knightCoordNum = Arrays.stream(knightCoord)
                .mapToInt(Integer::parseInt)
                .toArray();

        int count = (int)IntStream.range(0, 8)
                        .filter(i -> {
                            movedCoord[0] = knightCoordNum[0] + dx[i];
                            movedCoord[1] = knightCoordNum[1] + dy[i];

                            return Arrays.stream(movedCoord)
                                    .filter(value -> value > 0 && value < 9)
                                    .count() == 2;
                        }).count();


        System.out.println(count);
        return count;
    }

    public static void main(String[] args) throws Exception{

        BufferedReader bufferedReader
                =new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();

        System.out.println(function(input));

    }//End Of Main
}
