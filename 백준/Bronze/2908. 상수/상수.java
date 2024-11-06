import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputSplit = br.readLine().split(" ");
        String first = inputSplit[0];
        String second = inputSplit[1];

        StringBuilder sb = new StringBuilder();
        int reverseFirst = Integer.parseInt(sb.append(first).reverse().toString());
        sb.setLength(0);
        int reverseSecond = Integer.parseInt(sb.append(second).reverse().toString());

        int result = Math.max(reverseFirst, reverseSecond);
        System.out.println(result);

    }
}