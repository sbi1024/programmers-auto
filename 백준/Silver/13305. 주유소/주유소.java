import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] distances = new long[st.countTokens()];
        for (int i = 0; i < distances.length; i++) {
            distances[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long[] price = new long[size];
        for (int i = 0; i < price.length; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        long totalPrice = 0;
        long minPrice = price[0];
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