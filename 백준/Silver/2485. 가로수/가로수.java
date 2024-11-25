import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int forCount = Integer.parseInt(br.readLine());
        int[] array = new int[forCount];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);
        int[] gap = new int[array.length - 1];
        for (int i = 0; i < array.length - 1; i++) {
            gap[i] = array[i + 1] - array[i];
        }

        int gapStand = gap[0];
        for (int i = 1; i < gap.length; i++) {
            gapStand = gcm(gap[i], gapStand);
        }
        
        int result = 0;
        for (int g : gap) {
            result += (g / gapStand) - 1;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int gcm(int a, int b) {
        while (b > 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}