import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);
		
		List<Integer> listA = Arrays.stream( br.readLine().split(" ") ).map(Integer::parseInt).collect(Collectors.toList());
		List<Integer> listB = Arrays.stream( br.readLine().split(" ") ).map(Integer::parseInt).collect(Collectors.toList());
		
		// listA는 오름차순
		// listB는 내림차순
		Collections.sort(listA);
		Collections.sort(listB, Collections.reverseOrder());
		
		// 교체
		for(int i = 0; i < k; i++) {
			int t = listA.get(i);
			listA.set(i, listB.get(i));
			listB.set(i, t);
		}
		
		int sum = 0;
		for(int num : listA) {
			sum += num;
		}
		System.out.println(sum);
	}
}