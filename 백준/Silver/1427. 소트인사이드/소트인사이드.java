import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split("");
        Arrays.sort(split);
        for (String s : split) sb.append(s);
        bw.write(sb.reverse().toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

