import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int forCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < forCount; i++) {
            int[] result = new int[4];
            double doubleValue = Double.parseDouble(br.readLine());
            int intValue = (int) doubleValue / 25;
            result[0] = intValue;
            doubleValue %= 25;
            if (doubleValue != 0) {
                intValue = (int) doubleValue / 10;
                result[1] = intValue;
                doubleValue %= 10;
                if (doubleValue != 0) {
                    intValue = (int) doubleValue / 5;
                    result[2] = intValue;
                    doubleValue %= 5;
                    if (doubleValue != 0) {
                        result[3] = (int) doubleValue;
                    }
                }
            }

            for (int value : result) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}