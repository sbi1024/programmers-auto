import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int value1 = Integer.parseInt(st.nextToken());
        int value2 = Integer.parseInt(st.nextToken());
        int value3 = Integer.parseInt(st.nextToken());
        int value4 = Integer.parseInt(st.nextToken());

        int[] array = new int[4];

        array[0] = value1;
        array[1] = value2;
        array[2] = Math.abs(value3 - value1);
        array[3] = Math.abs(value4 - value2);

        System.out.println(Math.min(array[0], Math.min(array[1], Math.min(array[2], array[3]))));
    }
}