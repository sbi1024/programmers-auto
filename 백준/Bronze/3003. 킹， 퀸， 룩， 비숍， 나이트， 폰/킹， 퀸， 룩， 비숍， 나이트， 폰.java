import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1 1 2 2 2 8
        StringBuilder sb = new StringBuilder();
        int[] value = new int[]{1, 1, 2, 2, 2, 8};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splitStr = br.readLine().split(" ");
        for (int i = 0; i < splitStr.length; i++) {
            sb.append(value[i] - Integer.parseInt(splitStr[i])).append(" ");
        }
        System.out.println(sb);
    }
}