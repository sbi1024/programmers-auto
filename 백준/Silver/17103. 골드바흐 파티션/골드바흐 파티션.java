import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int tcValMax = Integer.MIN_VALUE;
        int tcCount = Integer.parseInt(br.readLine());
        int[] tcArray = new int[tcCount];
        for (int i = 0; i < tcArray.length; i++) {
            tcArray[i] = Integer.parseInt(br.readLine());
            if (tcArray[i] > tcValMax) {
                tcValMax = tcArray[i];
            }
        }

        boolean[] isPrime = new boolean[tcValMax + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int tc : tcArray) {
            int count = 0;
            for (int i = 2; i <= tc / 2; i++) {
                if (isPrime[i] && isPrime[tc - i]) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

