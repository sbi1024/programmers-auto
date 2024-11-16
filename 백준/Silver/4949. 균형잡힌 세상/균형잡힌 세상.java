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
            for (int i = 0; i < input.length() - 1; i++) {
                char ch = input.charAt(i);
                if (ch == '[' || ch == '(') {
                    deque.addLast(ch);
                } else if (ch == ']' || ch == ')') {
                    if (deque.isEmpty()) {
                        deque.addLast(ch);
                        break;
                    } else {
                        Character peekLast = deque.peekLast();
                        if (isMatch(peekLast, ch)) deque.removeLast();
                        else {
                            deque.addLast(ch);
                            break;
                        }
                    }
                }
            }
            if (deque.isEmpty()) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
            deque.clear();
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static boolean isMatch(char open, char close) {
        return (open == '[' && close == ']') || (open == '(' && close == ')');
    }
}