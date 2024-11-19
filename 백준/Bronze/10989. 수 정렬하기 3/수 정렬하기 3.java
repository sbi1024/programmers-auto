import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int forCount = Integer.parseInt(br.readLine());
        int[] array = new int[forCount];

        for (int i = 0; i < forCount; i++) array[i] = Integer.parseInt(br.readLine());
        Arrays.sort(array);

        for (int a : array) sb.append(a).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}