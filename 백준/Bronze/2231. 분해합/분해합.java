import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int value = Integer.parseInt(br.readLine());
        for (int i = 1; i < value; i++) {
            int temp = i;
            int sum = 0;

            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if (i + sum == value) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}