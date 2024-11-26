import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String enter = "ENTER";

        int count = Integer.parseInt(br.readLine());
        String[] array = new String[count];
        for (int i = 0; i < count; i++) {
            array[i] = br.readLine();
        }

        int result = 0;
        HashSet<String> set = new HashSet<>();
        for (int i = 1; i < array.length; i++) {
            if (array[i].equals(enter)) {
                result += set.size();
                set = new HashSet<>();
            } else set.add(array[i]);
            if (i == array.length - 1) result += set.size();
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}