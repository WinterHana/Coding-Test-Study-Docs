import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {

	private static List<List<Integer>> graph = new ArrayList<>();
	private static int n = 0;
	private static int m = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);

		for(int i = 0; i < n; i++) {
			graph.add( Arrays.stream(br.readLine().split(""))  // 숫자를 각 자릿수마다 끊어서 배열에 저장
					.map(Integer::parseInt)
					.collect(Collectors.toList()) );
		}
		
		int cnt = 0;
		// 각 노드마다 DFS를 수행하여 카운트 수행
		for (int x = 0; x <= n; x++) {
			for (int y = 0; y <= m; y++) {
				// 유효한 영역을 찾고, 그 영역을 완전히 폐쇄까지 한 후에 카운트 증가
				if( dfs(x,y) )
					cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	public static boolean dfs(int x, int y) {
		
		// 얼음틀을 벗어났으면 탐색 종료
		if ( (x < 0) || (x >= n) || (y < 0) || (y >= m) )
			return false;
		
		// 방문 가능한 노드면 탐색 수행
		if (graph.get(x).get(y) == 0) {
			graph.get(x).set(y, -1);  // 방문한 노드는 폐쇄
			
			// 상하좌우로 영역 폐쇄 수행
			dfs(x-1, y);
			dfs(x+1, y);
			dfs(x, y-1);
			dfs(x, y+1);
			
			return true;
		} else {
			// 폐쇄된 영역이거나 얼음틀인 경우 탐색 종료
			return false;
		}
	}
}