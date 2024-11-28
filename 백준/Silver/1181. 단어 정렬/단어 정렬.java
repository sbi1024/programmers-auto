import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입출력을 위한 BufferedReader, BufferedWriter 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 입력값의 개수
        int forCount = Integer.parseInt(br.readLine());
        // 중복 제거를 위한 Set 변수 선언
        Set<String> set = new TreeSet<>((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < forCount; i++) {
            set.add(br.readLine());
        }

        for (String str : set) {
            sb.append(str).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}