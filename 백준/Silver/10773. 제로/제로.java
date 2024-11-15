import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int forCount = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < forCount; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                deque.removeLast();
            } else {
                deque.addLast(input);
            }
        }
        int sum = 0;
        for (Integer value : deque) {
            sum += value;
        }
        System.out.println(sum);
    }
}