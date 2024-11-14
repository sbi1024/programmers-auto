import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int forCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < forCount; i++) {
            long input = Long.parseLong(br.readLine());
            while (!isPrime(input)) {
                input++;
            }
            System.out.println(input);
        }
    }

    public static boolean isPrime(long input) {
        if (input <= 1) return false;
        for (long i = 2; i <= Math.sqrt(input); i++) {
            if (input % i == 0) {
                return false;
            }
        }
        return true;
    }
}