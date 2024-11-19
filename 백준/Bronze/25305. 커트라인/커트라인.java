import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int[] array = new int[length];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) array[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(array);
        System.out.println(array[length - count]);

        br.close();
    }
}