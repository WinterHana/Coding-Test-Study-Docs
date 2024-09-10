import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MainClass {
	
	public static void main(String[] args) throws Exception {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Set<Integer> posessionSet = Arrays.stream( br.readLine().split(" ") ).map(Integer::parseInt).collect(Collectors.toSet());
		
		int m = Integer.parseInt(br.readLine());
		
		for(int requestNumber : Arrays.stream( br.readLine().split(" ") ).map(Integer::parseInt).toArray(Integer[]::new)) {
			
			if (posessionSet.contains(requestNumber))
				System.out.print("yes ");
			else
				System.out.print("no ");
		}
	}
}
```


### 계수정렬 풀이
고유번호가 1에서 1백만 사이의 정수이므로, 계수정렬을 이용하여 정렬없이 $O(1)$ 수준의 탐색을 기대할 수 있다.

```python
import sys

# 0 : 없는 품목
# 1 : 보유 품목
# 총 백만개의 품목 보유(고유 번호는 1부터 1백만 사이 정수)
posessionList = [0] * 1000001

n = int(input())
for uniqueNumber in list(map(int, sys.stdin.readline().split())):
    posessionList[uniqueNumber] = 1

m = int(input())
for requestNum in list(map(int, sys.stdin.readline().split())):

    # 보유 품목이 조회되는 경우 yes 출력
    if posessionList[requestNum] == 1:
        print("yes", end=" ")
    else:
        print("no", end=" ")
```

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MainClass {
	
	/*
	 * 보유 품목 = 1
	 * 미보유 품목 = 0
	 * 총 백만개의 품목 보유(고유 번호는 1부터 1백만 사이 정수)
	 */
	private static int[] posessionArr = new int[1000001]; 
	
	public static void main(String[] args) throws Exception {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt( br.readLine() );
		for(int uniqueNumber : Arrays.stream( br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new) ) {
			posessionArr[uniqueNumber] = 1;
		}
		int m = Integer.parseInt( br.readLine() );
		for(int uniqueNumber : Arrays.stream( br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new) ) {
			if(posessionArr[uniqueNumber] == 1)
				System.out.print("yes ");
			else
				System.out.print("no ");
		}
	}
}