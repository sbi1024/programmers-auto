import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int forCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < forCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            BigInteger value1 = factorial(second);
            BigInteger value2 = factorial(second - first);
            BigInteger value3 = factorial(first);
            BigInteger multiply = value2.multiply(value3);
            BigInteger divide = value1.divide(multiply);
            sb.append(divide).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        BigInteger inputN = BigInteger.valueOf(n);
        BigInteger zero = BigInteger.ZERO;
        BigInteger one = BigInteger.ONE;
        while (inputN.compareTo(zero) > 0) {
            result = result.multiply(inputN);
            inputN = inputN.subtract(one);
        }
        return result;
    }
}