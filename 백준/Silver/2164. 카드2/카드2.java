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
        for (int i = 1; i <= forCount; i++) {
            deque.addLast(i);
        }
        while (deque.size() != 1) {
            deque.removeFirst();
            deque.addLast(deque.removeFirst());
        }
        System.out.println(deque.pop());
    }
}