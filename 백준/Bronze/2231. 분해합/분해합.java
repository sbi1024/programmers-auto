import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int inputInt = Integer.parseInt(inputStr);
        for (int i = 1; i < inputInt; i++) {
            String[] split = String.valueOf(i).split("");
            int sum = 0;
            for (String str : split) {
                sum += Integer.parseInt(str);
            }
            if (i + sum == inputInt) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
        br.close();
    }
}