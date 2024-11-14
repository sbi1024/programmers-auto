import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputCount = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        Map<Integer, Integer> inputMap = new HashMap<>(inputCount);

        for (int i = 0; i < inputCount; i++) {
            int input = Integer.parseInt(inputs[i]);
            inputMap.put(input, inputMap.getOrDefault(input, 0) + 1);
        }

        int findCount = Integer.parseInt(br.readLine());
        String[] queries = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < findCount; i++) {
            int findValue = Integer.parseInt(queries[i]);
            sb.append(inputMap.getOrDefault(findValue, 0)).append(" ");
        }
        System.out.println(sb);
    }
}
