import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class MainClass {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		// 바라보는 방향
		//  0 : 북쪽, 1: 동쪽, 2: 남쪽, 3: 서쪽
		int direction = Integer.parseInt(st.nextToken());
		
		// 게임 맵 생성
		// 0: 육지, 1: 바다
		List<List<Integer>> myMap = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			// stream API를 사용하여 문자열을 쉽게 변환
			myMap.add( Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()) );
		}
		
		// 게임 컨트롤러 (상하좌우)
		int[] moveListX = {-1, 1, 0, 0};
		int[] moveListY = {0, 0, -1, 1};
		
		// 게임 실행
		int cnt = 1;
		int missCnt = 0;  // 이동 불가 카운트. 4회 누적 시 게임 종료
		while(true) {
			// 1. 현재 위치에서 바라보는 방향을 기준으로 반시계로 90도씩 탐색 (0 -> 3 -> 2 -> 1 -> 0)
			int chooseDirection = -1;
			if(direction == 0)
				chooseDirection = 3;
			else
				chooseDirection = direction - 1;
			
			// 2-1. 탐색한 칸이 갈 수 있는 칸이면, 그 방향을 보게 회전한 다음 한 칸 전진
			int nextX = x + moveListX[chooseDirection];
			int nextY = y + moveListY[chooseDirection];
			if(myMap.get(nextX).get(nextY) == 0) {
				direction = chooseDirection;
				x = nextX;
				y = nextY;
				cnt++;
			} else {
				// 2-2. 탐색한 칸이 갈 수 없는 칸이면 그냥 회전만 함
				if(missCnt < 4) {
					missCnt++;
					continue;
				} else if(missCnt == 4) {
					// 3-1. 동서남북 모든 방향이 이미 가본 칸이거나 바다인 경우, 현재 보는 방향을 유지한 채로 1보 후퇴
					nextX = x - moveListX[chooseDirection];
					nextY = y - moveListY[chooseDirection];
					// 3-2. 만약 후퇴해야 할 칸이 바다인 경우 게임 종료
					if(myMap.get(nextX).get(nextY) == 1)
						break;
					else {
						x = nextX;
						y = nextY;
					}	
				} else {
					// 오류
					System.exit(0);
				}
			}
		}
		System.out.println(cnt);
	}
}