import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int result = 0;
        String[] split = br.readLine().split(" ");
        for (String str : split) {
            if (isPrime(Integer.parseInt(str))) {
                result++;
            }
        }
        System.out.println(result);
    }

    public static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

}