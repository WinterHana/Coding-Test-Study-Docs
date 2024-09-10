import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

// 내부 메소드로 정의하면 static  메소드에서 인스턴스 생성 불가능
class CurrentLocation {
	
	private int x;
	private int y;

	public CurrentLocation(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
}

public class MainClass {

	static List<List<Integer>> graph = new ArrayList<>();
	// 상하좌우
	static int[] moveControlX = {-1, 1, 0, 0};
	static int[] moveControlY = {0, 0, -1, 1};
	
	static int n;
	static int m; 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		
		for(int i = 0; i < n; i++) {
			graph.add( Arrays.stream(br.readLine().split(""))
					.map(Integer::parseInt)
					.collect(Collectors.toList())
					);
			
		}
		
		// 너비 탐색으로 출구 탐색
		System.out.println(bfs()); 
	}
	
	private static int bfs() {
		
		Queue<CurrentLocation> queue = new LinkedList<>();
		queue.offer(new CurrentLocation(0,0));  // 초기 위치 정의
		
		while ( !queue.isEmpty()) {
		
			int nextX = -1;
			int nextY = -1;
			
			CurrentLocation temp = queue.poll();
			int currentX = temp.getX();
			int currentY = temp.getY();
			
			for(int i = 0; i < 4; i++) {
				nextX = currentX + moveControlX[i];
				nextY = currentY + moveControlY[i];
							
				// 그래프를 벗어나는 경우 무시
				if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m ) {
					continue;
				} else {
					// 괴물을 만나는 경우는 무시
					if (graph.get(nextX).get(nextY) == 0)
						continue;
					
					// 해당 노드를 처음 방문하는 경우만 취급
					if(graph.get(nextX).get(nextY) == 1) {
						// 지도 상에 카운트를 증가시켜줌
						int cnt = graph.get(currentX).get(currentY) + 1;
						graph.get(nextX).set(nextY, cnt);
						
						// queue에 다음 경로로 넣어둠
						queue.offer(new CurrentLocation(nextX, nextY));
					}
				}
			}
		}
				
		return graph.get(n-1).get(m-1);
	}
}