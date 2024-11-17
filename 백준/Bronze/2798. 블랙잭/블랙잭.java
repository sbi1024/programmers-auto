import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());
        int[] array = new int[count];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) array[i] = Integer.parseInt(st.nextToken());


        int result = 0;
        int minusStandard = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    int sum = array[i] + array[j] + array[k];
                    if (sum <= value) {
                        int minus = value - sum;
                        if (minus < minusStandard) {
                            minusStandard = minus;
                            result = sum;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}