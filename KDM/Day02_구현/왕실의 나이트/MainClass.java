import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		// 연산의 편의성을 위해 문자를 숫자로 변환
		int x = temp.charAt(0) - 'a' + 1;
		int y = temp.charAt(1) - '1' + 1;  

		// 이동 가능 명령 배열
		int[] moveListX = {2, 2, -2, -2, 1, -1, 1, -1};
		int[] moveListY = {1, -1, 1, -1, 2, 2, -2, -2};
		
		int cnt = 0;
		for(int i = 0; i < 8; i++) {
			
			int nextX = x + moveListX[i];
			int nextY = y + moveListY[i];
			
			// 범위를 넘어서는 경우 무시
			if( nextX < 1 || nextX > 8 || nextY < 1 || nextY > 8 ) {
				continue;
			} else {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}