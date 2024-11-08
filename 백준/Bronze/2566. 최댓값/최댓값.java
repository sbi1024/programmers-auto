import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int maxValue = Integer.MIN_VALUE;
        int[] point = new int[2];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String[] splitStr = br.readLine().split(" ");
            for (int j = 0; j < splitStr.length; j++) {
                int strToInt = Integer.parseInt(splitStr[j]);
                if (strToInt > maxValue) {
                    maxValue = strToInt;
                    point[0] = i + 1;
                    point[1] = j + 1;
                }
            }
        }
        System.out.println(maxValue);
        System.out.println(point[0] + " " + point[1]);
    }
}