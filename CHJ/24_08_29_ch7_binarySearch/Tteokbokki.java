import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Tteokbokki {
    static long m;
    static long[] tteoks;

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(System.in));
        long[] inputs = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long n = inputs[0];
        m = inputs[1];
        tteoks = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(tteoks);

        //H는 0부터 떡 최대길이까지야.
        //H의 최댓값을 구해라 = 여기서 H값을 찾아라야.
        //조건은 M에 맞춰야대 합을. 합이 작아야대 M만큼 가야대
        // 합이 M값에 가까워야해. H

        System.out.printf("n :: %d, m :: %d, tteoks :: %s\n", n, m, Arrays.toString(tteoks) );

        // H 잡았어. 그 다음에는 array에 H를 빼봐. 그리고 sum 구해봐.
        // M < sum? 그러면 sum을 줄여야지. 그러러면 H를 늘리면 돼. end = insert - 1

        //H와 sum은 반비레함 sum충분해야하니 H부족해야함.
        // H0---------------------------------100
        // sum MAX                          MIN


        long sum = 0;
        long h = 0;

        long maxH = tteoks[(int)n-1];

        long[] arraysH = new long[(int)maxH + 1];
        for (long i = 0; i <= maxH; i++) {
            arraysH[(int)i] = i;
        }//End of For

        //H는 0부터 떡볶이 최대값까지여야해

        long result = search(arraysH, 0, maxH + 1);
        System.out.printf("%d  %d  %d\n",sum, h, maxH);
//        System.out.println(Arrays.toString(arraysH));
        System.out.println(result);

        //
        long realResult = result >= 0 ? result : -result-1;//sum은 m보다 언제나 커야함. 그러므로 + 1을 해준다.
        System.out.println(realResult);

    }//End Of Main

    public static long search(long[] array, long startP, long endP) {
        endP = endP - 1;//exclusive
        long insertP;
        while(startP <= endP) {
            insertP = startP + (endP - startP)/2;
            long finalInsertP = insertP;
            long sum = Arrays.stream(tteoks).map(element->{
                long temp = element - finalInsertP;
                if(temp <= 0) {
                    return 0;
                } else {
                    return temp;
                }
            }).sum();
            System.out.printf("실행 전 결과 startP::%d, endP::%d h::%d sum::%d\n",startP,endP,insertP,sum);
            if(m == sum) {
                return insertP;
            } else if ( m > sum) {
                endP = insertP - 1;
            } else {
                startP = insertP + 1;
            }
            System.out.printf("실행 후 결과 startP::%d endP::%d h::%d sum::%d\n",startP,endP,insertP,sum);
        }
        return - (startP - 1) -1;
    }
}

/*
m < sum 떡이 충분한 경우잖아.
떡볶이 떡 길이 일정하지 않음
한봉지 떡총길이 절단기로 자름
H를 지정하면 한번에 절단함
높이가 H보다 긴 떡은 H 위 부분이 잘린다.
그니까 높이가 H면 최대높이 15가 되고
그거보다 작은건 안잘린다는 거임
손님은 잘린 떡 길이 합만큼 가져감
떡의 개수 N 요청한 떡의 길이 M(총합)
최소 M 만큼의 떡을 얻기 위해
설정할 수 있는 H의 최대값을 구해라
2*10^9이자나
19-H 15-H 10-H 17-H 한다음 수학말고 시뮬해야대
1해보고 2해보고 ... 계속해봐야대 M이상일때까지
그거의 총합이 >= M 이어야해
떡개수 10^6야. NlogN * (N logN + N)
4 6
19 15 10 17
4 55555555
100000000 55555555 888888888 444444444
4 10
200 200 200 200

177이면 23 23 23 23 92이다.
178이면 22 22 22 22 88이다.
179이면 21 21 21 21 84이다.

4 100
200 200 200 200


이 코드가 1<=N<=1000000, 1<=M<=2000000000, 0<=h <=1000000000

 * */