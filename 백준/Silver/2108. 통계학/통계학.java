import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입출력을 위한 BufferedReader, BufferedWriter, StringBuilder 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 입력값의 개수
        int count = Integer.parseInt(br.readLine());
        // 평균값, 중앙값, 범위 값을 구하기 위해 사용되는 변수
        int[] array = new int[count];
        // 최빈값을 구하기 위해 사용되는 변수, -4000 값이 0번 인덱스 4000 값이 8000번 인덱스
        int[] freq = new int[8001];
        // 최빈값을 1차적으로 구하기 위한 변수
        int maxFreq = 0;
        // 합계를 구하기 위한 변수
        int sum = 0;
        // 반복문을 통해 합계(sum), array, freq (최빈값을 구하기 위한 배열 변수)
        for (int i = 0; i < count; i++) {
            int input = Integer.parseInt(br.readLine());
            sum += input;
            array[i] = input;
            // 여기서 입력되는 값에 대해 각 인덱스에 맞게 값이 증가함
            // 예를들어서 4000 값이 두번 입력되었다면 freq[8000] = 2
            freq[input + 4000]++;
            // 가장 많이 나온 최빈값을 찾기위해서 여기서 먼저 계산해서 값을 가지고 있음
            // 1차로 먼저 값을 구하는 이유는, 최빈값이 동일한 값이 존재할 수 있기에 먼저 계산을 진행
            maxFreq = Math.max(maxFreq, freq[input + 4000]);
        }

        // 배열 정렬 > 사실상 중앙값을 구하기 위함에 있음
        Arrays.sort(array);
        // 산술평균 값
        sb.append(Math.round((double) sum / count)).append("\n");
        // 중앙값
        sb.append(array[count / 2]).append("\n");

        // 최빈값 구하는 중요 로직
        int realFreqValue = 0;
        // 첫번째 최빈값을 찾을때 true 로 변경
        boolean flag = false;
        for (int i = 0; i < 8001; i++) {
            if (maxFreq == freq[i]) {
                if (!flag) {
                    // -4000을 하는 이유는 0번 인덱스에 -4000값을 할당하도록 위에서 설정하였기 때문
                    // 실제 값을 계산하기 위해서는 0번인덱스의 값 = i - 4000 
                    realFreqValue = i - 4000;
                    flag = true;
                } else {
                    // flag 가 ture 라는것은 이미 첫번째 최빈값을 찾았고 현재 이 로직으로 들어왔을때가
                    // 두번째로 작은 최빈값이라는 뜻
                    realFreqValue = i - 4000;
                    break;
                }
            }
        }

        // 최빈값 계산
        sb.append(realFreqValue).append("\n");
        // 범위값 계산
        sb.append(array[count - 1] - array[0]).append("\n");
        // bw로 출력하기 위해 문자열로 변환 후 write
        bw.write(sb.toString());
        bw.flush();
        // 자원 반납
        bw.close();
        br.close();
    }
}