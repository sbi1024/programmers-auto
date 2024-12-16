import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] distances = new int[st.countTokens()];
        for (int i = 0; i < distances.length; i++) {
            distances[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] price = new int[size];
        for (int i = 0; i < price.length; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int totalPrice = 0;
        int minPrice = price[0];
        for (int i = 0; i < distances.length; i++) {
            totalPrice += distances[i] * minPrice;
            if (minPrice > price[i + 1]) {
                minPrice = price[i + 1];
            }
        }

        bw.write(totalPrice + "");
        bw.flush();
        bw.close();
        br.close();
    }
}