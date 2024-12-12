import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());

        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (total == 0) {
                break;
            }

            int mod = total / array[i];
            if (mod != 0) {
                total -= mod * array[i];
                count += mod;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}

