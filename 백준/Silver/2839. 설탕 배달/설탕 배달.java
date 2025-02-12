import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 입력값을 선언함
        int totalWeight = Integer.parseInt(br.readLine());
        final int FIVE_VALUE = 5; // 나눌 값을 상수로 정의
        final int THREE_VALUE = 3; // 나눌 값을 상수로 정의
        int result = 0; // 출력할 결과값 선언
        
        // [핵심 아이디이]
        // 5kg 으로 나누어서 배달하는게 가장 적은 개수로 배달하는 경우이다.
        // 하지만, 5kg로 나누어 배달하는 경우만 존재하는 것이 아니기에, 5kg로 나누어 지지 않는 경우
        // 3kg로 하나 배달한다는 가정하에 총 무게 (totalWeight) 에서 -3 처리 후에, 다시 5kg로 나누어 지는지 확인 
        while (totalWeight > 0) {
            int fiveRemain = totalWeight % FIVE_VALUE; // 나머지 값
            int fiveMod = totalWeight / FIVE_VALUE; // 몫 값
            // 만약 5kg로 나누어 떨어진다면
            if (fiveRemain == 0) {
                // 몫 만큼 결과값 + 후 반복문 종료
                result += fiveMod;
                break;
            }
            // 위 조건을 만족하지 않는다는 것은, 5kg로 나누어 떨어지지 않는다는 것
            // 3kg 하나를 배달해야 함을 알 수 있음.
            totalWeight -= THREE_VALUE;
            result++;
        }
        // 만약에 총 무게가 0보다 작다는건, 5,3kg로 배달할수 없음을 알 수 있음
        if (totalWeight < 0)result = -1; // -1로 반환
        
        // 결과값 출력
        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}