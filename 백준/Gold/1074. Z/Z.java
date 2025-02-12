import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, r, c, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // 배열 크기 2^N 계산
        N = (int) Math.pow(2, N);

        // 원점 초기화
        int y = 0;
        int x = 0;

        // N이 1보다 클 동안 반복 (1이 되면 종료)
        while (N > 1) { 
            N /= 2; // 한 단계 줄이기

            // r, c 가 4개의 영역 중 어디에 있는지 판단
            if (r < y + N && c < x + N) { // 상좌 (1사분면)
                // 그대로 진행 (이전 ans 추가 없음)
            } 
            else if (r < y + N && c >= x + N) { // 상우 (2사분면)
                ans += N * N * 1;
                x += N; // 우로 이동
            } 
            else if (r >= y + N && c < x + N) { // 하좌 (3사분면)
                ans += N * N * 2;
                y += N; // 아래로 이동
            } 
            else { // 하우 (4사분면)
                ans += N * N * 3;
                y += N; // 아래로 이동
                x += N; // 우로 이동
            }
        }

        System.out.println(ans);
    }
}