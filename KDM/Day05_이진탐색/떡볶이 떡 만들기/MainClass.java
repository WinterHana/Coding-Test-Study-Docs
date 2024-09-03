import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class MainClass {
	
	public static void main(String[] args) throws Exception {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Integer[] riceCakeArr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
		
		// 가능한 떡 길이의 범위를 최대로 잡아줌
		int startHeight = 0;
		int endHeight = 1000000000;
		int result = -1;  // 가장 적합한 커팅 길이
		while(startHeight <= endHeight) {
			
			// 떡 자를 기준 길이
			int midHeight = (startHeight + endHeight) / 2;
			
			int total = 0;
			for (int selectedHeight : riceCakeArr) {
				if(selectedHeight > midHeight) 
					total += (selectedHeight - midHeight);
			}
			
			// 떡 길이가 필요 이상으로 많이 남는 경우 기준선을 높임
			if(total > m) {
				startHeight = midHeight + 1;
			} 
			// 떡 길이가 최소치를 넘지 못하는 경우 기준선을 낮춤
			else {
				endHeight = midHeight - 1;
				result = midHeight;  // 만약 최소치에 걸치면 이게 정답
			}
		}
		
		System.out.println(result);
	}
}