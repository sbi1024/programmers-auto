import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = Integer.parseInt(br.readLine());
        int result = (int) Math.sqrt(input);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}