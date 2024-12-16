import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int tcCount = Integer.parseInt(br.readLine());
        int[] testCases = new int[tcCount];
        int maxN = 0;


        for (int t = 0; t < tcCount; t++) {
            testCases[t] = Integer.parseInt(br.readLine());
            maxN = Math.max(maxN, testCases[t]);
        }


        long[] dp = new long[maxN + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= maxN; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }

        
        for (int t = 0; t < tcCount; t++) {
            sb.append(dp[testCases[t]]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


}

