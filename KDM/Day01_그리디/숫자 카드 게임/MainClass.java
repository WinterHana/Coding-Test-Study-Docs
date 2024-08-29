import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainClass {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  // BufferedReader은 항상 문자 stream만 읽을 수 있음
		StringTokenizer tempArr = new StringTokenizer( br.readLine() );  // 공백을 기준으로 문자열 token 생성 (default가 공백임)
		int n = Integer.parseInt(tempArr.nextToken());
		int m = Integer.parseInt(tempArr.nextToken());
		
		int minVal = 1;
		for(int i = 0; i < n; i++) {
			tempArr = new StringTokenizer( br.readLine() );
			// 주어진 행 내에서 가장 작은 수 찾기
			int tempMinVal = 10001;  // Integer.MAX_VALUE 상수값을 쓰면 int값 중 가장 큰 값을 넣어줄 수 있다.
			for(int j=0; j<m; j++) {
				tempMinVal = Math.min(Integer.parseInt(tempArr.nextToken()), tempMinVal);
			}
			// 주어진 행 내 최소값과 전체 행 내 최소값 비교하여 더 큰 수를 선택
			minVal = Math.max(minVal, tempMinVal);
		}
		
		System.out.println(minVal);
	}
}