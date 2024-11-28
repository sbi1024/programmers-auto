import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입출력을 위한 BufferedReader, BufferedWriter, StringBuilder 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 입력값의 개수
        int forCount = Integer.parseInt(br.readLine());
        // 원데이터를 저장할 배열 변수
        int[] originalArray = new int[forCount];
        // 정렬데이터를 저장할 배열 변수
        int[] sortArray = new int[forCount];
        // 입력값을 공백기준으로 나누기 위한 StringTokenizer 객체 생성
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 반복문을 통해 originalArray, sortArray에 데이터 할당
        for (int i = 0; i < forCount; i++) {
            String line = st.nextToken();
            originalArray[i] = Integer.parseInt(line);
            sortArray[i] = Integer.parseInt(line);
        }

        // 배열 오름차순으로 정렬
        Arrays.sort(sortArray);

        int index = 0;
        // Map<정렬데이터, index(순서)> 로 저장하기 위한 map 변수 선언
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < forCount; i++) {
            int value = sortArray[i];
            // 중복된 데이터인 경우는 거르기 위함
            if (!map.containsKey(value)) {
                map.put(value, index);
                index++;
            }
        }
        // 원데이터를 몇번째 인덱스에 해당하는지 map 에서 찾기
        for (int ori : originalArray) {
            // sb.append() 메서드를 통해 저장
            sb.append(map.get(ori)).append(" ");
        }
        // bw로 출력하기 위해 문자열로 변환 후 write
        bw.write(sb.toString());
        bw.flush();
        // 자원 반납
        bw.close();
        br.close();
    }
}