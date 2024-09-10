import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainClass {
	
	public static void main(String[] args) throws Exception {
			
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		List<Integer> coinList = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			coinList.add( sc.nextInt() );
		}
		
		int[] dpTable = new int[10001];
		Arrays.fill(dpTable, 99999);  // 배열 내 모든 값을 99999로 채움
		dpTable[0] = 0;
		
		for(int coin : coinList) {
			for(int i = coin; i < m+1; i++) {
				dpTable[i] = Math.min(dpTable[i], dpTable[i-coin] + 1);
			}
		}
		
		if(dpTable[m] == 99999)
			System.out.println(-1);
		else
			System.out.println(dpTable[m]);
		sc.close();
	}
}