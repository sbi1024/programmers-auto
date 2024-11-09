import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int sideLength = (int) Math.pow(2, count) + 1;
        int result = (int) Math.pow(sideLength, 2);
        System.out.println(result);
    }
}