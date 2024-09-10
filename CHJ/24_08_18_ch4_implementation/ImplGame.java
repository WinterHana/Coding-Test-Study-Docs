import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ImplGame {

    /*
    * N X M 세로 가로
    * 칸은 육지 or 바다
    * 캐릭터 처음칸은 육지
    *
    * 0 1 2 3
    * 북 동 남 서
    *
    * 처음 0,0
    * 아래 +1 오른쪽 +1
    *
    * 1. 현재방향을 기준으로 왼쪽방향부터 시작. 북쪽이면 서쪽이네.
    *
    * 2.
    * 가봣으면 회전만
    * 안가봣으면 회전하고 이동
    * 3.
    * 모든방향 가봣어 or 바다야. 그러면 방향 가만히 있고 한칸 뒤로가. 뒤에가 바다면 움직임 멈춰.
    *
    *
    * 캐릭터 방문한 칸 수 출력해.
    *
    *
4 4
1 1 0
1 1 1 1
1 0 0 1
1 1 0 1
1 1 1 1
    * */
    public static void main(String[] args) throws Exception{

        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(System.in));

//        String을 int[]로!
        int[] line1 = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxX = line1[0];//N
        int maxY = line1[1];//M

        int[] line2 = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int characterX = line2[0];
        int characterY = line2[1];

        int movedCharacterX = 0;
        int movedCharacterY = 0;//움직이려고 하는 곳. 안좋은 이름같아.

        int characterDirectionValue = line2[2];//0 1 2 3 북 동 남 서중 하나야.
        int[][] map = new int[maxX][maxY];//0,0부터 시작이야

        //맵만드는중
        for (int i = 0; i < maxY; i++) {
            int[] line3 = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < maxX; j++) {
                map[i][j] = line3[j];
            }//End of For
        }//End of For

        Arrays.stream(map)
                .map(Arrays::toString)
                .forEach(System.out::println);

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        int[] dmove = {3, 2, 1, 0};//서 남 동 북

        boolean[][] checked = new boolean[maxX][maxY];//다 기본값이 false지?
        int count = 1;
        boolean ended = false;

        int characterDirectionIndex = IntStream.range(0, dmove.length)
                .filter(i -> characterDirectionValue == dmove[i])
                .findFirst()
                .orElseThrow();



        while(!ended) {
                System.out.printf("내 위치는 %d, %d\n",characterX,characterY);

            for (int i = 1; i <= 4; i++) {
                System.out.printf("i는 %d\n", i);
                System.out.println("갈 방향은"+dx[characterDirectionIndex] + "," + dy[characterDirectionIndex] + "방향이야");
                //1 바다 0 육지

                movedCharacterX = characterX + dx[characterDirectionIndex];
                movedCharacterY = characterY + dy[characterDirectionIndex];

                if (1 == map[movedCharacterX][movedCharacterY]
                        || checked[movedCharacterX][movedCharacterY]) {
                    System.out.println("못가");
                    //바라보는 방향을 기준으로 한칸 뒤로 간다면

                    if (i == 4){
                        movedCharacterX = dx[(characterDirectionIndex + 2) % dmove.length];
                        movedCharacterY = dy[(characterDirectionIndex + 2) % dmove.length];
                        System.out.println(movedCharacterX + "," + movedCharacterY + "방향으로 간다면");

                        if (1 == map[movedCharacterX][movedCharacterY]) {
                            System.out.println("뒤로갔을때 바다니까 끝내야지");
                            ended = true;
                            break;
                        }
                    }
                    //if(뒤로간곳이 바다라면 ended = true이다.)
                    //움직이지마
                } else {
                    //움직여
                    System.out.println("움직일 수 있어 앞은 땅이야");
                    characterX = movedCharacterX;
                    characterY = movedCharacterY;
                    System.out.printf("내 위치는 %d, %d\n",characterX,characterY);
                    checked[movedCharacterX][movedCharacterY] = true;
                    count++;

                }

                System.out.println("방향을 왼쪽으로 바꿔");


                characterDirectionIndex = (characterDirectionIndex + i) % dmove.length;



                System.out.println("이제 방향은"+dx[characterDirectionIndex] + "," + dy[characterDirectionIndex] + "방향이야");
            }//End of For
        }

        System.out.println(count);
        bufferedReader.close();


    }//End Of Main
}
