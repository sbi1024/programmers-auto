import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] result = new int[26];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toLowerCase();
        char[] charArray = input.toCharArray();
        for (char ch : charArray) {
            result[ch - 97]++;
        }

        int max = Integer.MIN_VALUE;
        for (int k : result) {
            if (k > max) {
                max = k;
            }
        }

        int maxCount = 0;
        int maxIndex = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] == max) {
                maxIndex = i;
                maxCount++;
            }
        }

        if (maxCount == 1) {
            char ch = (char) (maxIndex + 'a');
            System.out.println(String.valueOf(ch).toUpperCase());
        } else {
            System.out.println("?");
        }
    }
}