import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < first + second; i++) {
            if (i < first) {
                set.add(br.readLine());
            } else {
                if (set.contains(br.readLine())) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}