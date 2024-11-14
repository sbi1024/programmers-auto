import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long first = Long.parseLong(st.nextToken());
        long second = Long.parseLong(st.nextToken());
        long lcm = first * second / gcd(Math.max(first, second), Math.min(first, second));
        System.out.println(lcm);
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}