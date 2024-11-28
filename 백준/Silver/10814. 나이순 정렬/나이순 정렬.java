import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입출력을 위한 BufferedReader, BufferedWriter, StringBuilder 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int forCount = Integer.parseInt(br.readLine());
        String[][] array = new String[forCount][3];
        for (int i = 0; i < forCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            array[i][0] = st.nextToken();
            array[i][1] = st.nextToken();
            array[i][2] = Integer.toString(i);
        }

        Arrays.sort(array, (o1, o2) -> {
            if (!o1[0].equals(o2[0])) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            } else {
                return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
            }
        });

        for (String[] arr : array) {
            sb.append(arr[0]).append(" ").append(arr[1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}