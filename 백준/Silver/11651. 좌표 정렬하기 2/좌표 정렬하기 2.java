import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int forCount = Integer.parseInt(br.readLine());
        int[][] array = new int[forCount][2];
        for (int i = 0; i < forCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        for (int[] arr : array) {
            sb.append(arr[0]).append(" ").append(arr[1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}