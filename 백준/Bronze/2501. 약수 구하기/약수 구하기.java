import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int number = Integer.parseInt(split[0]);
        int count = Integer.parseInt(split[1]);
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                index ++;
                if (index == count) {
                    System.out.println(i);
                    return;
                }
            }
        }
        System.out.println("0");
    }
}