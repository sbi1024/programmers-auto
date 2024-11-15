import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int forCount = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < forCount; i++) {
            String[] split = br.readLine().split(" ");
            if (split.length == 2) {
                int X = Integer.parseInt(split[1]);
                method1(deque, X);
            } else {
                int methodCallIndex = Integer.parseInt(split[0]);
                if (methodCallIndex == 2) {
                    method2(deque);
                } else if (methodCallIndex == 3) {
                    method3(deque);
                } else if (methodCallIndex == 4) {
                    method4(deque);
                } else if (methodCallIndex == 5) {
                    method5(deque);
                }
            }
        }
        System.out.println(sb);
    }

    public static void method1(Deque<Integer> deque, int X) {
        deque.addFirst(X);
    }

    public static void method2(Deque<Integer> deque) {
        if (!deque.isEmpty()) {
            Integer firstValue = deque.removeFirst();
            sb.append(firstValue).append("\n");
        } else {
            sb.append(-1).append("\n");
        }
    }

    public static void method3(Deque<Integer> deque) {
        sb.append(deque.size()).append("\n");;
    }

    public static void method4(Deque<Integer> deque) {
        if (deque.isEmpty()) {
            sb.append(1).append("\n");
        } else {
            sb.append(0).append("\n");
        }
    }

    public static void method5(Deque<Integer> deque) {
        if (!deque.isEmpty()) {
            sb.append(deque.getFirst()).append("\n");
        } else {
            sb.append(-1).append("\n");
        }
    }
}