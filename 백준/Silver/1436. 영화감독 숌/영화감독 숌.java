import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int value = Integer.parseInt(br.readLine());
        int count = 0;
        int index = 666;
        while (value != count) {
            if (Integer.toString(index).contains("666")) {
                count++;
            }
            index++;
        }
        System.out.println(index - 1);
    }
}