import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int forCount = Integer.parseInt(br.readLine());
        int[][] array = new int[forCount][2];
        for (int i = 0; i < forCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }

        // 회의 정렬: 끝나는 시간 기준, 끝나는 시간이 같으면 시작 시간 기준
        Arrays.sort(array, (a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int count = 1;
        int secondStandValue = array[0][1];
        for (int i = 1; i < array.length; i++) {
            if (array[i][0] >= secondStandValue) {
                secondStandValue = array[i][1];
                count++;
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

