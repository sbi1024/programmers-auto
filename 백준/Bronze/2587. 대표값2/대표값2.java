import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        int sum = 0;
        int avg = 0;
        for (int i = 0; i < 5; i++) {
            int value = Integer.parseInt(br.readLine());
            sum += value;
            arr[i] = value;
        }
        avg = sum / 5;
        Arrays.sort(arr);

        System.out.println(avg);
        System.out.println(arr[2]);

        br.close();
    }
}