import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[Integer.parseInt(st.nextToken())];
        int range = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int standValue = 0;
        for (int i = 0; i < range; i++) {
            standValue += array[i];
        }

        int MAX_VALUE = standValue;
        for (int i = 1; i <= array.length - range; i++) {
            standValue = standValue - array[i - 1] + array[i + range - 1];
            if (standValue > MAX_VALUE) {
                MAX_VALUE = standValue;
            }
        }

        bw.write(String.valueOf(MAX_VALUE));
        bw.flush();
        bw.close();
        br.close();
    }
}

