import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int input;
        while ((input = Integer.parseInt(br.readLine())) != 0) {
            int count = 0;
            for (int i = input + 1; i <= input * 2; i++) {
                if (isPrime(i)) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    public static boolean isPrime(int input) {
        if (input <= 1) return false;
        if (input <= 3) return true;
        if (input % 2 == 0 || input % 3 == 0) return false;
        for (int i = 2; i <= Math.sqrt(input); i++) {
            if (input % i == 0) {
                return false;
            }
        }
        return true;
    }
}