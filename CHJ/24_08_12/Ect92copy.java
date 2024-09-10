import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ect92copy {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 받습니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄에서 정수 n을 입력받습니다.
        int n = Integer.parseInt(br.readLine());

        // 리스트를 생성합니다.
        List<Integer> array = new ArrayList<>();

        // n개의 정수를 입력받아 리스트에 추가합니다.
        for (int i = 0; i < n; i++) {
            array.add(Integer.parseInt(br.readLine()));
        }

        // 리스트를 내림차순으로 정렬합니다.
        Collections.sort(array, Collections.reverseOrder());

        // 정렬된 리스트를 출력합니다.
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
