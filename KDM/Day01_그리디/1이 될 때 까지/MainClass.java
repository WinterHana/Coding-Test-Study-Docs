import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainClass {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		// n이 1이 될 때까지 반복
		while(n > 1) {
			// 나누어 떨어지는 경우 나누기 우선
			if(n % k == 0) {
				n = n / k;
			} else {
				n--;
			}
			cnt++;
		}
		
		System.out.println(cnt);
	}
}