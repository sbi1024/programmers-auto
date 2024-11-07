import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] strArray = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for (String str : strArray) {
            input = input.replaceAll(str, " ");
        }
        System.out.println(input.length());
    }
}