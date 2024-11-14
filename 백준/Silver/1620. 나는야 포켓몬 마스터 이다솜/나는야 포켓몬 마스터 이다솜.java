import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int inputCount = Integer.parseInt(st.nextToken());
        int findCount = Integer.parseInt(st.nextToken());

        Map<String, Integer> inputStringMap = new HashMap<>();
        Map<Integer, String> inputIntMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= inputCount + findCount; i++) {
            if (i <= inputCount) {
                String input = br.readLine();
                inputStringMap.put(input, i);
                inputIntMap.put(i, input);
            } else {
                String findValue = br.readLine();
                try {
                    int index = Integer.parseInt(findValue);
                    String name = inputIntMap.get(index);
                    sb.append(name).append("\n");
                } catch (NumberFormatException e) {
                    Integer index = inputStringMap.get(findValue);
                    sb.append(index).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}

