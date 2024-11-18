import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Map<Integer, Integer>> deque = new ArrayDeque<>();
        int forCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= forCount; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            int value = Integer.parseInt(st.nextToken());
            map.put(i, value);
            deque.addLast(map);
        }
        Map<Integer, Integer> remove = deque.removeFirst();
        Integer value = remove.get(1);
        sb.append(1).append(" ");
        while (!deque.isEmpty()) {
            if (value > 0) {
                for (int i = 0; i < value - 1; i++) deque.addLast(deque.removeFirst());
                remove = deque.removeFirst();
            } else {
                for (int i = 0; i < Math.abs(value) - 1; i++) deque.addFirst(deque.removeLast());
                remove = deque.removeLast();
            }
            Integer index = new ArrayList<>(remove.keySet()).get(0);
            sb.append(index).append(" ");
            value = remove.get(index);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
