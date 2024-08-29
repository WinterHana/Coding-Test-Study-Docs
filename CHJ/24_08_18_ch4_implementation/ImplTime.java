import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ImplTime {

    //N입력

    //4입력되면 0~4시 59 59 까지 시각중에 3이 하나라도 포함된 모든 경우 출력

    public static void main(String[] args) throws Exception{

        //00시 00분 00초
        //3 13 23 30~39 43 53 >> 60초에서 15개
        //시나 분에서 3이 있으면 60개
        // 시가 저 숫자중에 하나인지 확인 > Y : 60 * 60
        /*
        * 시가 저 숫자중에 하나인지 확인
        * Y : 60 * 60
        * N : 15개
        * */

        BufferedReader bufferedReader
                =new BufferedReader(new InputStreamReader(System.in));

        String N = bufferedReader.readLine();

        //n=3, 0가능


        int hours = Integer.parseInt(N);
        int minutes = 59;
        int seconds = 59;
        int count = 0;

        for (int i = 0; i <= hours; i++) {//5이면 0~5돌려
            System.out.printf("hours :: %d\n", i);
            if(String.format("%d",i).contains("3")){
                count = count + 3600;
                System.out.println("3600을 더해요.");
                continue;
            }

            for (int j = 0; j <= minutes; j++) {
                System.out.printf("minutes :: %d\n", j);
                if(String.valueOf(j).contains("3")){
                    count = count + 60;
                    System.out.println("60을 더해요.");
                    continue;
                }

                for (int k = 0; k <= seconds; k++) {
                    System.out.printf("seconds :: %d\n", k);
                    if(String.valueOf(k).contains("3")){
                        count++;
                        System.out.println("1을 더해요.");
                    }

                }//End of For

            }//End of For

        }//End of For

        System.out.println(count);


    }//End Of Main
}
