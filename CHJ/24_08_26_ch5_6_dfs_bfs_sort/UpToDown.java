import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class UpToDown {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int i = 0;

        Integer[] arrInt = new Integer[n];

        while(n > i){
            arrInt[i] = Integer.parseInt(bufferedReader.readLine());
            i++;
        }

        Arrays.sort(arrInt, Comparator.reverseOrder());

        System.out.printf("%s",Arrays.toString(arrInt));
    }//End Of Main
}
