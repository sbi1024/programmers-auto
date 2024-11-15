import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int forCount = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < forCount; i++) {
            String input = br.readLine();
            char ch = input.charAt(0);
            switch (ch) {
                case '1':
                    int x = Integer.parseInt(input.substring(2));
                    deque.addFirst(x);
                    break;
                case '2':
                    if (!deque.isEmpty()) sb.append(deque.removeFirst()).append('\n');
                    else sb.append(-1).append('\n');
                    break;
                case '3':
                    sb.append(deque.size()).append('\n');
                    break;
                case '4':
                    if (deque.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case '5':
                    if (!deque.isEmpty()) sb.append(deque.getFirst()).append('\n');
                    else sb.append(-1).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}
