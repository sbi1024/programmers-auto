import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int value = Integer.parseInt(br.readLine());
        for (int i = 1; i < value; i++) {
            char[] charArray = Integer.toString(i).toCharArray();
            int sum = 0;
            for (char ch : charArray) {
                sum += ch - '0';
            }
            if (i + sum == value) {
                result = i;
                break;
            }
        }
        System.out.println(result);
        br.close();
    }
}