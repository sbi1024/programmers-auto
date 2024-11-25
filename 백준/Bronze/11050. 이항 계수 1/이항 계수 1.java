

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        int value1 = factorial(first);
        int value2 = factorial(first - second);
        int value3 = factorial(second);

        int result = value1 / (value2 * value3);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int factorial(int n) {
        int result = 1;
        while (n > 0) {
            result *= n;
            n--;
        }
        return result;
    }
}