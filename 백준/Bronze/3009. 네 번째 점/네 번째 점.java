import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int x1 = Integer.parseInt(input1[0]);
        int y1 = Integer.parseInt(input1[1]);

        String[] input2 = br.readLine().split(" ");
        int x2 = Integer.parseInt(input2[0]);
        int y2 = Integer.parseInt(input2[1]);

        String[] input3 = br.readLine().split(" ");
        int x3 = Integer.parseInt(input3[0]);
        int y3 = Integer.parseInt(input3[1]);

        int x = x1 == x2 ? x3 : x1 == x3 ? x2 : x1;
        int y = y1 == y2 ? y3 : y1 == y3 ? y2 : y1;

        System.out.println(x + " " + y);
    }
}