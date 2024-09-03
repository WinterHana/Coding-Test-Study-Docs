import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
/*
4
1 3 1 5
9
1 3 5 1 6 8 5 1 100

1 5 6 5 100 = 117
5 8 1 100 > 114

8
1 3 5 1 6 13 5 100

1+ 5 + 13 + 100 = 119

* */
public class AntWorrier {

    //식량창고가 일직선으로 잇음
    //약탈할거
    //인접한거 공격받으면 알 수 있음 메뚜기 정찰병
    //1 3 1 5면 3이랑 5 약탈하면 댐
    static HashMap<Integer,Integer> memories = new HashMap<>();
    static ArrayList<Integer> room = new ArrayList<>();

    public static void main(String[] args) throws Exception{

        BufferedReader
                bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());


        while (stringTokenizer.hasMoreTokens()){
            room.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        System.out.println(n);
        System.out.println(room);



        //합은 106이 답이겟네 1 5 100
        //오해가 무조건 홀수 짝수로 하면 안돼.
        //2칸을 띄울때가 더 이득일 때도 있어. 3칸을 띄울때가 더 이득일때는 없네
        // 그런데 그런 생각 하는 것보다
        //이런식으로 한번에 답이 안나오는 문제는 다이나믹인지 의심해
        //전체 해가 부분 해로 합쳐지는가를 봐
        //그리고 또 뭐 봐야했었지 모르겠다. 검색하자
        //f(9)는 100이야. f(9)
        //f(9) = f(8) or f(7) + arr[8]
        //나머지도 마찬가지임

        //n은 인덱스
        //f(n) = f(n-1) or f(n-2) + arr[n]
        //f(0) = arr[0]
        //f(1) = f(0) or arr[1]
        //f(2) = f(1) or f(0) + arr[2]

        int solution = execute(n-1);

        System.out.println(solution);

    }//End Of Main

    static int execute(int n) {
        //기저 > 사용 > 재귀 > 저장
        if ( n == 0) {
            return room.get(0);
        }

        if (!memories.isEmpty()){
            return memories.get(n);
        }
        int returnValue = 0;
        if ( n == 1) {
            returnValue = Math.max(execute(n-1), room.get(1));
        }
        if ( n >= 2) {
            returnValue = Math.max(execute(n - 1), execute(n - 2) + room.get(n));
        }
        memories.put(n,returnValue);
        return returnValue;

    }

}
