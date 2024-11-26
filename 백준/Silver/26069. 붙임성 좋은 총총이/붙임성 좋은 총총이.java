import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String stand = "ChongChong";

        Set<String> set = new HashSet<>();
        set.add(stand);
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String second = st.nextToken();
            if (set.contains(first) || set.contains(second)) {
                set.add(first);
                set.add(second);
            }
        }
        
        bw.write(String.valueOf(set.size()));
        bw.flush();
        bw.close();
        br.close();
    }
}