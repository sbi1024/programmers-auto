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

        int MAX_VALUE = Integer.MIN_VALUE;
        for (int i = 0; i <= array.length - range; i++) {
            int sum = 0;
            for (int j = i; j < i + range; j++) {
                sum += array[j];
            }
            if (MAX_VALUE < sum) {
                MAX_VALUE = sum;
            }
        }

        bw.write(String.valueOf(MAX_VALUE));
        bw.flush();
        bw.close();
        br.close();
    }
}

