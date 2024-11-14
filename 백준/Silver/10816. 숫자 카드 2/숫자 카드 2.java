import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputCount = Integer.parseInt(br.readLine());
        Map<Integer, Integer> inputMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < inputCount; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (inputMap.get(input) == null) inputMap.put(input, 1);
            else inputMap.put(input, inputMap.get(input) + 1);
        }
        StringBuilder sb = new StringBuilder();
        int findCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < findCount; i++) {
            int findValue = Integer.parseInt(st.nextToken());
            Integer value = inputMap.get(findValue);
            if (value == null) sb.append(0).append(" ");
            else sb.append(value).append(" ");
        }
        System.out.println(sb);
    }
}

