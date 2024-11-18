import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<int[]> deque = new ArrayDeque<>();

        int forCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= forCount; i++) {
            int value = Integer.parseInt(st.nextToken());
            deque.addLast(new int[]{i, value});
        }

        int[] removeArray = deque.removeFirst();
        int value = removeArray[1];
        sb.append(removeArray[0]).append(" ");

        while (!deque.isEmpty()) {
            if (value > 0) {
                for (int i = 0; i < value - 1; i++) deque.addLast(deque.removeFirst());
                removeArray = deque.removeFirst();
            } else {
                for (int i = 0; i < (-value) - 1; i++) deque.addFirst(deque.removeLast());
                removeArray = deque.removeLast();
            }
            value = removeArray[1];
            sb.append(removeArray[0]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}