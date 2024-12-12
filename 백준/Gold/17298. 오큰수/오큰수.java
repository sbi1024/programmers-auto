import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int count = Integer.parseInt(br.readLine());
        int[] result = new int[count];
        Arrays.fill(result, -1);
        String[] split = br.readLine().split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            int curValue = Integer.parseInt(split[i]);

            while (!stack.isEmpty() && stack.peek() <= curValue) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            }

            stack.push(curValue);
        }


        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

