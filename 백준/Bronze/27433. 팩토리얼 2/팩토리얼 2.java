import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] array = new long[21];
        array[0] = array[1] = 1;
        for (int i = 2; i < 21; i++) array[i] = i * array[i - 1];

        System.out.println(array[Integer.parseInt(br.readLine())]);
        br.close();
    }
}