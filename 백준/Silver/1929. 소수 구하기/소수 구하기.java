import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int startIndex = Integer.parseInt(st.nextToken());
        int endIndex = Integer.parseInt(st.nextToken());
        for (int i = startIndex; i <= endIndex; i++) {
            if (isPrime(i)) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean isPrime(int input) {
        if (input <= 1) return false;
        if (input <= 3) return true;
        if (input % 2 == 0) return false;
        for (int i = 2; i <= Math.sqrt(input); i++) {
            if (input % i == 0) {
                return false;
            }
        }
        return true;
    }
}