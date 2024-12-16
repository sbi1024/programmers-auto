import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] minusArray = br.readLine().split("-");
        int result = 0;
        for (int i = 0; i < minusArray.length; i++) {
            int sum = 0;
            String[] plusArray = minusArray[i].split("\\+");
            for (String s : plusArray) {
                sum += Integer.parseInt(s);
            }

            if (i == 0) {
                result += sum;
            } else {
                result -= sum;
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}