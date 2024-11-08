import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean[][] result = new boolean[101][101];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int forCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < forCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            for (int j = first; j < first + 10; j++) {
                for (int k = second; k < second + 10; k++) {
                    result[j][k] = true;
                }
            }
        }

        int trueCount = 0;
        for (boolean[] booleans : result) {
            for (boolean aBoolean : booleans) {
                if (aBoolean) {
                    trueCount++;
                }
            }
        }

        System.out.println(trueCount);
    }
}