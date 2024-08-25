import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tempArr = br.readLine().split(" ");
		int n = Integer.parseInt(tempArr[0]);
		int m = Integer.parseInt(tempArr[1]);
		int k = Integer.parseInt(tempArr[2]);
		tempArr = br.readLine().split(" ");

        // Stream API를 사용하여 정렬
		List<Integer> numberList = Arrays.stream(tempArr).map(Integer::parseInt).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

		int biggest = numberList.get(0);
		int secondary = numberList.get(1);
		
		int sum = 0;
		int biggestCnt = m / (k + 1) * k + m % (k + 1);
		sum += biggest * biggestCnt;
		sum += secondary * (m - biggestCnt);
		
		System.out.println(sum);
	}
}