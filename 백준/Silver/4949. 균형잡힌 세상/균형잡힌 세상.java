import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Character> deque = new ArrayDeque<>();

        String input;
        while (!(input = br.readLine()).equals(".")) {
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (ch == '[' || ch == '(') {
                    deque.addLast(ch);
                } else if (ch == ']') {
                    Character peekLast = deque.peekLast();
                    if (deque.isEmpty()) {
                        deque.addLast(ch);
                        break;
                    } else if (peekLast == '(' || peekLast == ')') {
                        deque.addLast(ch);
                        break;
                    } else if (peekLast == '[') {
                        deque.removeLast();
                    }
                } else if (ch == ')') {
                    Character peekLast = deque.peekLast();
                    if (deque.isEmpty()) {
                        deque.addLast(ch);
                        break;
                    } else if (peekLast == '[' || peekLast == ']') {
                        deque.addLast(ch);
                        break;
                    } else if (peekLast == '(') {
                        deque.removeLast();
                    }
                }
            }
            if (deque.isEmpty()) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }

            deque.clear();
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}