import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Ect92 {
    public static void main(String[] args) throws IOException {

        String[] arr = {"apple", "banana", "pear"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();  // 문자열 길이에 따른 내림차순 정렬
            }
        });
        System.out.println(Arrays.toString(arr));  // [banana, apple, pear]
    }
}
