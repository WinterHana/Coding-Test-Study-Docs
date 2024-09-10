import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) throws Exception {
			
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] dpTable = new int[1001];
		dpTable[1] = 1;
		dpTable[2] = 3;
		
		for ( int i = 3; i < n+1; i++) {
			
			dpTable[i] = dpTable[i-2] * 2 + dpTable[i-1];
		}
		
		System.out.println(dpTable[n]);
		sc.close();
	}
}