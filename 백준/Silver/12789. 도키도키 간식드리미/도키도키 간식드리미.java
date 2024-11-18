import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();

        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) deque1.add(Integer.parseInt(st.nextToken()));


        int stand = 1;
        while (!deque1.isEmpty()) {
            Integer value = deque1.removeFirst();
            if (value == stand) {
                stand++;
                while (!deque2.isEmpty() && (deque2.peekFirst() == stand)) {
                    deque2.removeFirst();
                    stand++;
                }
            } else deque2.addFirst(value);
        }

        if (deque2.isEmpty()) bw.write("Nice");
        else bw.write("Sad");

        bw.flush();
        bw.close();
        br.close();
    }
}