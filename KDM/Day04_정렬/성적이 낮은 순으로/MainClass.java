import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StudentInfo implements Comparable<StudentInfo>{
	private String name;
	private int score;
	
	StudentInfo(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	/// setter는 필요없어서 안 만듦

	// 점수 기준 오름차순 정렬 선언
	@Override
	public int compareTo(StudentInfo other) {
		// TODO Auto-generated method stub
		if(this.score < other.score)
			return -1;
		else
			return 1;
	}
}

public class MainClass {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// StudentInfo[] studentList = new StudentInfo[n]; 
		List<StudentInfo> studentList = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
            // studentList[i] = new StudentInfo( temp[0], Integer.parseInt(temp[1]) );
			studentList.add(new StudentInfo( temp[0], Integer.parseInt(temp[1]) )); 
		}
		
		// Arrays.sort(studentList);  // Arrays는 배열만 허용. 배열 기반으로 풀어도 돌아감.
		Collections.sort(studentList);  // Collections는 배열 외의 collectable 객체만 허용
		
		for(StudentInfo student : studentList) {
			System.out.print(student.getName() + " ");
		}
	}

}