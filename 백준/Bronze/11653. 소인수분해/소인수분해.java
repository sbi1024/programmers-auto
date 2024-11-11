import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        if (!(number == 1)) {
            for (int i = 2; i <= number; i++) {
                while (number % i == 0) {
                    number /= i;
                    System.out.println(i);
                }
            }
        }
    }
}