import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int forCount = Integer.parseInt(st.nextToken());
        int findMod = Integer.parseInt(st.nextToken());

        int[] array = new int[forCount];
        int MAX_VALUE = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            if (array[i] > MAX_VALUE) {
                MAX_VALUE = array[i];
            }
        }

        long left = 1;
        long right = MAX_VALUE;
        long result = 0;
        while (left <= right) {
            long count = 0;
            long mid = (left + right) / 2;
            for (int a : array) {
                long temp = a - mid;
                count += temp >= 0 ? temp : 0;
            }

            if (count >= findMod) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}