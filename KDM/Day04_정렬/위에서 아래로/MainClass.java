import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class MainClass {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// int[] sequence = new int[n];  // C언어는 배열 크기 변수를 못 넣는데,  java는 된다.
		Integer[] sequence = new Integer[n];  // Arrays.sort()에 Collections.reverseOrder()를 사용하려면 Wrapper class 배열로 정의해야 한다.
		for (int i = 0; i < n; i++) {
			sequence[i] =  Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(sequence, Collections.reverseOrder());
		
		for(int i : sequence) {
			System.out.print(i + " ");
		}
	}

}