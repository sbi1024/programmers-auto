import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입출력을 위한 BufferedReader, BufferedWriter, StringBuilder 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 입력값의 개수
        int forCount = Integer.parseInt(br.readLine());
        // 중복 제거를 위한 Set 변수 선언
        Set<String> set = new HashSet<>();
        for (int i = 0; i < forCount; i++) {
            set.add(br.readLine());
        }

        // 정렬하기 위한 List 변수 선언 (Set 을 통해 생성)
        List<String> list = new ArrayList<>(set);
        // 정렬 진행
        list.sort((o1, o2) -> {
            // 문자열 길이기준으로 오름차순 정렬 (짧으면 앞으로 옴)
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else {
                // 길이가 같으면 사전순으로 정렬
                return o1.compareTo(o2);
            }
        });

        // 반복문을 통해 sb.append() 메서드 호출
        for (String str : list) {
            sb.append(str).append("\n");
        }

        // bw로 출력하기 위해 문자열로 변환 후 write
        bw.write(sb.toString());
        bw.flush();
        // 자원 반납
        bw.close();
        br.close();
    }
}