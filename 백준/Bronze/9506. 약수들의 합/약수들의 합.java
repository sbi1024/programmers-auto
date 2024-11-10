import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number;
        while ((number = Integer.parseInt(br.readLine())) != -1) {
            isPerfect(number);
        }
    }

    public static void isPerfect(int number) {
        StringBuilder sb = new StringBuilder();
        int result = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sb.append(i).append(" + ");
                result += i;
            }
        }
        if (result == number) {
            String subStr = sb.substring(0, sb.length() - 3);
            System.out.println(number + " = " + subStr);
        } else {
            System.out.println(number + " is NOT perfect.");
        }
    }
}