
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입출력을 위한 BufferedReader, BufferedWriter, StringBuilder 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 좌표값을 저장할 리스트 선언 (타입은 1차원 배열)
        List<int[]> list = new ArrayList<>();
        // 입력값의 개수
        int forCount = Integer.parseInt(br.readLine());
        // 빈복문을 통해 리스트에 데이터 저장
        for (int i = 0; i < forCount; i++) {
            // 입력값을 공백 기준으로 데이터를 자르기 위한 StringTokenizer 객체 생성
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 리스트에 저장할 1차원 배열 객체 생성
            int[] tempArray = new int[2];
            tempArray[0] = Integer.parseInt(st.nextToken());
            tempArray[1] = Integer.parseInt(st.nextToken());
            list.add(tempArray);
        }

        // 리스트 정렬
        list.sort((o1, o2) -> {
            if (o1[0] < o2[0]) {
                return -1;
            } else if (o1[0] == o2[0]) {
                if (o1[1] < o2[1]) {
                    return -1;
                } else if (o1[1] == o2[1]) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        });

        // 정렬된 리스트 sb.append() 메서드를 통해 저장
        for (int[] intArray : list) {
            sb.append(intArray[0])
                    .append(" ")
                    .append(intArray[1])
                    .append("\n");
        }

        // bw로 출력하기 위해 문자열로 변환 후 write
        bw.write(sb.toString());
        bw.flush();
        // 자원 반납
        bw.close();
        br.close();
    }
}
      