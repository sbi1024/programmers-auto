import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputSplit = br.readLine().split("");
        for (String input : inputSplit) {
            if (input.equals("A") || input.equals("B") || input.equals("C")) {
                result += 2;
            } else if (input.equals("D") || input.equals("E") || input.equals("F")) {
                result += 3;
            } else if (input.equals("G") || input.equals("H") || input.equals("I")) {
                result += 4;
            } else if (input.equals("J") || input.equals("K") || input.equals("L")) {
                result += 5;
            } else if (input.equals("M") || input.equals("N") || input.equals("O")) {
                result += 6;
            } else if (input.equals("P") || input.equals("Q") || input.equals("R") || input.equals("S")) {
                result += 7;
            } else if (input.equals("T") || input.equals("U") || input.equals("V")) {
                result += 8;
            } else if (input.equals("W") || input.equals("X") || input.equals("Y") || input.equals("Z")) {
                result += 9;
            }
        }
        System.out.println(result + inputSplit.length);
    }
}