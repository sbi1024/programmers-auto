import java.io.*;

public class Main {
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        memo = new int[n + 1];
        int recursiveCalls = fibRecursiveCalls(n);

        int dpAssignments = n - 2;

        bw.write(recursiveCalls + " " + dpAssignments);
        bw.flush();
        bw.close();
        br.close();
    }

    static int fibRecursiveCalls(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        if (memo[n] > 0) {
            return memo[n];
        }

        memo[n] = fibRecursiveCalls(n - 1) + fibRecursiveCalls(n - 2);
        return memo[n];
    }
}

