import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 종류가 N 이야
 * 최소한으로 해서 합이 M원이 되어야 해
 * 순서만 다른 것은 같은 경우이다. 택하는 거임. 집합,종류를 분류? 그런 느낌
 * 2원 3원 단위의 화폐가 있으면 15원을 만드려면 3원 5개
 *
 * 4원 5원의 단위라면 ... 24원을 만들려면 5원이 4개 4원이 1개야.
 * 24원을 소인수분해해봐. 아니야...그게 아니야
 * 동전개수가 최소여야해.
 * 4와 5로 모든 조합을 돌려보고 결과값을 저장해. 결과중에 최소를 출력해.
 * 나눌수 있어야 뺄 수 있지 않음? ㅇㅇ 맞아. 그래야 0이 되니까.
 * ? 아니야. 4,19라면 24원은 동전6개필요하지만, 5,19라면 24원은 동전 2개 필요해.
 *
 * 먼저 큰 거로 빼봐. ?
 * 아이디어 떠오르지 못했음.
 * 책보니 1,2,3,4,5 전부보고 점화식을 만들었네
 * N이 100이었으니 그 아이디어 충분히 떠올릴 수 있었어.
 *
 *
 */

public class EfficientCurrency {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in)
        );


        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int[] currencyTypes = new int[n];


        for (int i = 0; i < n; i++) {
            currencyTypes[i] = Integer.parseInt(bufferedReader.readLine());
        }


        int[] memories = new int[m + 1];
        Arrays.fill(memories, 10001 * (m + 1));
        memories[0] = 0;


        //화폐종류별로 돌려야함
        for (int i = 0; i < n; i++) {
            //
            for (int j = currencyTypes[i]; j <= m; j++) {

                if (memories[j - currencyTypes[i]] != 10001) {
                    memories[j] = Math.min(memories[j], memories[j - currencyTypes[i]] + 1);
                }
            }
        }


        if (memories[m] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(memories[m]);
        }
    }
}

/**
n, m = map(int, input().split())
array = []
for i in range(n):
    array.append(int(input()))
 d = [10001] *(m + 1)
 d[0] = 0
 for i in range(n):
    for j in range(array[i], m + 1):
        if d[j - array[i]] != 10001:
            d[j] = min(d[j], d[j - array[i]] + 1)

 if d[m] == 10001:
    print(-1)
 else:
    print(d[m])
 */