import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int forCount = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < forCount; i++) {
            String input = br.readLine();
            char ch = input.charAt(0);
            switch (ch) {
                case '1':
                    deque.addFirst(Integer.parseInt(input.substring(2)));
                    break;
                case '2':
                    deque.addLast(Integer.parseInt(input.substring(2)));
                    break;
                case '3':
                    if (deque.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(deque.removeFirst()).append("\n");
                    break;
                case '4':
                    if (deque.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(deque.removeLast()).append("\n");
                    break;
                case '5':
                    sb.append(deque.size()).append("\n");
                    break;
                case '6':
                    if (deque.isEmpty()) sb.append("1").append("\n");
                    else sb.append("0").append("\n");
                    break;
                case '7':
                    if (deque.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(deque.peekFirst()).append("\n");
                    break;
                case '8':
                    if (deque.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(deque.peekLast()).append("\n");
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}