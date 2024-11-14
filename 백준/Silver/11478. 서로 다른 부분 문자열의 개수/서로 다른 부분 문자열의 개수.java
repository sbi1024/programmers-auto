import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> uniqueStr = new HashSet<>();
        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                String subStr = input.substring(i, j);
                uniqueStr.add(subStr);
            }
        }
        System.out.println(uniqueStr.size());
    }
}