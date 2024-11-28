import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입출력을 위한 BufferedReader, BufferedWriter, StringBuilder 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 입력값의 개수
        int forCount = Integer.parseInt(br.readLine());
        // 나중에 출력값을 찾기 위한 원데이터를 담기 위한 배열 변수 선언
        int[] findArray = new int[forCount];
        // 중복 제거 및 정렬된 데이터를 저장하기 위해 Set 변수 선언
        Set<Integer> set = new TreeSet<>();
        // 공백값으로 자르기 위한 StringTokenizer 객체 생성
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < forCount; i++) {
            int input = Integer.parseInt(st.nextToken());
            findArray[i] = input;
            set.add(input);
        }

        // 원데이터를 찾기 위한 map 변수 선언
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>(set);
        for (int i = 0; i < list.size(); i++) {
            // 원데이터가 정렬값으로 몇번째인지 value 값으로 저장
            map.put(list.get(i), i);
        }

        // 원데이터가 정렬되었을때 몇번째 인덱스에 해당하는지 반복문으로 찾음
        for (int fa : findArray) {
            sb.append(map.get(fa)).append(" ");
        }

        // bw로 출력하기 위해 문자열로 변환 후 write
        bw.write(sb.toString());
        bw.flush();
        // 자원 반납
        bw.close();
        br.close();
    }
}