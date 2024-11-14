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
        int firstValue = Integer.parseInt(st.nextToken());
        int secondValue = Integer.parseInt(st.nextToken());

        Set<String> firstSet1 = new HashSet<>();
        Set<String> firstSet2 = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < firstValue; i++) {
            String value = st.nextToken();
            firstSet1.add(value);
            firstSet2.add(value);
        }

        Set<String> secondSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < secondValue; i++) {
            secondSet.add(st.nextToken());
        }

        firstSet1.removeAll(secondSet);
        secondSet.removeAll(firstSet2);
        System.out.println(firstSet1.size() + secondSet.size());
    }
}
