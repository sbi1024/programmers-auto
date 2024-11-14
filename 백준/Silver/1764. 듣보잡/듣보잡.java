import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstValue = Integer.parseInt(st.nextToken());
        int secondValue = Integer.parseInt(st.nextToken());

        Set<String> noListenSet = new HashSet<>();
        TreeSet<String> sortSet = new TreeSet<>();
        int result = 0;
        for (int i = 1; i <= firstValue + secondValue; i++) {
            if (i <= firstValue) {
                noListenSet.add(br.readLine());
            } else {
                String name = br.readLine();
                boolean isContain = noListenSet.contains(name);
                if (isContain) {
                    sortSet.add(name);
                    result++;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (String name : sortSet) {
            sb.append(name).append("\n");
        }

        System.out.println(result);
        System.out.println(sb);
    }
}

