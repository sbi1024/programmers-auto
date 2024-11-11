import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isFirstPrice = false;
        int firstPrice = 0;
        int primeSum = 0;
        int first = Integer.parseInt(br.readLine());
        int second = Integer.parseInt(br.readLine());
        for (int i = first; i <= second; i++) {
            if (isPrime(i)) {
                if (!isFirstPrice) {
                    firstPrice = i;
                    isFirstPrice = true;
                }
                primeSum += i;
            }
        }
        if (primeSum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(primeSum);
            System.out.println(firstPrice);
        }
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