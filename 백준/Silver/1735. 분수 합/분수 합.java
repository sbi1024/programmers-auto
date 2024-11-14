import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int value1 = Integer.parseInt(st.nextToken());
        int value2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int value3 = Integer.parseInt(st.nextToken());
        int value4 = Integer.parseInt(st.nextToken());

        int up = (value1 * value4) + (value2 * value3);
        int down = value2 * value4;

        int gcd = gcd(Math.max(up, down), Math.min(up, down));
        up /= gcd;
        down /= gcd;

        System.out.println(up + " " + down);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}