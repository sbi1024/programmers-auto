import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();
        int forCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < forCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();
            if (status.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        TreeSet<String> sortSet = new TreeSet<>(set);
        Iterator<String> iterator = sortSet.descendingIterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

