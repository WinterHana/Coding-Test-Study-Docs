import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MainClass {
	
	public static void main(String[] args) throws Exception {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[] warehouse = Arrays.stream( br.readLine().split(" ") ).map(Integer::parseInt).toArray(Integer[]::new);
		
		int[] dpTable = new int[1001];
		dpTable[1] = warehouse[0];
		dpTable[2] = Math.max(dpTable[1], warehouse[1]);
		
		for(int i = 3; i < n+1 ; i++) {
			
			dpTable[i] = Math.max(dpTable[i-1], dpTable[i-2] + warehouse[i-1]);
		}
		
		System.out.println(dpTable[n]);
	}
}