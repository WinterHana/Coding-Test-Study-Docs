import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) throws Exception {
			
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		// 모든 값은 0으로 초기화됨
		int[] dpTable = new int[30001];
		
		// DP table 만들기
		for(int i = 2; i < x + 1; i++) {

			dpTable[i] = dpTable[i - 1] + 1;
			
			if(i % 2 == 0) {
				dpTable[i] = Math.min(dpTable[i], dpTable[i / 2] + 1);
			} if (i % 3 == 0) {
				dpTable[i] = Math.min(dpTable[i], dpTable[i / 3] + 1);
			} if (i % 5 == 0) {
				dpTable[i] = Math.min(dpTable[i], dpTable[i / 5] + 1);
			}
		}
		
		System.out.println(dpTable[x]);
		
		sc.close();
	}
}