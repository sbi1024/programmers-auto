import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        if (count == 1) {
            System.out.println(0);
            return;
        }
        int[] xArray = new int[count];
        int[] yArray = new int[count];
        for (int i = 0; i < count; i++) {
            String[] splitStr = br.readLine().split(" ");
            xArray[i] = Integer.parseInt(splitStr[0]);
            yArray[i] = Integer.parseInt(splitStr[1]);
        }

        int minX = Arrays.stream(xArray).min().getAsInt();
        int minY = Arrays.stream(yArray).min().getAsInt();

        int maxX = Arrays.stream(xArray).max().getAsInt();
        int maxY = Arrays.stream(yArray).max().getAsInt();

        System.out.println((maxX - minX) * (maxY - minY));
    }
}