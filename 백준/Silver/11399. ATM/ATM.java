import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        int[] array = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i] =  array[i] + array[i - 1];
            sum += array[i];
        }
        bw.write(sum + "");
        bw.flush();
        bw.close();
        br.close();
    }
}