import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Character> deque = new ArrayDeque<>();

        int forCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < forCount; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);
                if (ch == '(') deque.push(ch);
                else {
                    if (deque.isEmpty()) {
                        // 강제 주입
                        deque.push(ch);
                        break;
                    } else {
                        if (deque.peekLast() == '(') deque.removeLast();
                        else deque.push(ch);
                    }
                }
            }
            if (deque.isEmpty()) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");

            deque.clear();
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}