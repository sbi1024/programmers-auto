import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int firstX = Integer.parseInt(st.nextToken());
        int firstY = Integer.parseInt(st.nextToken());
        int firstResult = Integer.parseInt(st.nextToken());
        int secondX = Integer.parseInt(st.nextToken());
        int secondY = Integer.parseInt(st.nextToken());
        int secondResult = Integer.parseInt(st.nextToken());

        for (int i = -999; i <= 999; i++) {
            for (int j = -999; j <= 999; j++) {
                int tempResult1 = firstX * i + firstY * j;
                if (tempResult1 == firstResult) {
                    int tempResult2 = secondX * i + secondY * j;
                    if (tempResult2 == secondResult) {
                        bw.write(i + " " + j);
                        bw.flush();
                        bw.close();
                        br.close();
                        return;
                    }
                }
            }
        }
    }
}