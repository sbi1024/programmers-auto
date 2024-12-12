import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        char[] charArray = br.readLine().toCharArray();
        String target = br.readLine();

        for (char ch : charArray) {
            stack.push(ch);
            if (stack.size() >= target.length()) {
                boolean flag = true;
                for (int j = 0; j < target.length(); j++) {
                    if (stack.get(stack.size() - target.length() + j) != target.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < target.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            sb.append("FRULA");
        } else {
            for (Character ch : stack) {
                sb.append(ch);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

