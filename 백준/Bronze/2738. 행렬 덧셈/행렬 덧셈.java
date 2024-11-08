import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] value = input.split(" ");

        int first = Integer.parseInt(value[0]);
        int second = Integer.parseInt(value[1]);

        int[][] firstArr = new int[first][second];
        int[][] secondArr = new int[first][second];

        for (int i = 0; i < (first * 2); i++) {
            String[] splitStr = br.readLine().split(" ");
            if (i < first) {
                for (int j = 0; j < splitStr.length; j++) {
                    firstArr[i][j] = Integer.parseInt(splitStr[j]);
                }
            } else {
                for (int j = 0; j < splitStr.length; j++) {
                    secondArr[i - first][j] = Integer.parseInt(splitStr[j]);
                }
            }
        }

        for (int i = 0; i < firstArr.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < firstArr[i].length; j++) {
                sb.append(firstArr[i][j] + secondArr[i][j]).append(" ");
            }
            System.out.println(sb);
        }
    }
}