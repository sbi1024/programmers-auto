import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String[][] result = new String[5][15];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            String[] split = input.split("");
            for (int j = 0; j < split.length; j++) {
                result[i][j] = split[j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                String str = result[j][i];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        System.out.println(sb);
    }
}