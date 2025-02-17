import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int R, C; // 가로 세로
    static boolean[] alphaVisit = new boolean[26]; // 알파벳 배열 선언 (방문 여부 확인)
    static int result; // 말이 지나온 칸 수
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] alphaBoard; // 입력값을 담을 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 가로 세로 변수 초기화
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 전역변수 초기화
        alphaBoard = new char[R][C];
        for (int i = 0; i < R; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                alphaBoard[i][j] = charArray[j];
            }
        }

        // 메서드 호출
        // 문제에서 말의 시작점이 1행 1열에 놓여있는데, 좌측 상단의 칸도 포함된다고 했음
        dfs(0, 0, 1);
        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    // 이 문제는 dfs 를 사용해야함
    // 이유 : 백트래킹을 사용해야함에도 이유가 있지만, 말이 상하좌우로 움직이면서 지금까지 나온 알파벳과는 다른 알파벳을 선택할 수 있어야 하기 때문
    static void dfs(int y, int x, int count) {
        // 백트래킹을 이용한 문제풀이 방식이기에 이전에 시도한 방식이
        // 더 많은 칸을 이동했을수도 있음
        // 그렇게에 최대값을 호출시에 무조건 담아놔야 함
        result = Math.max(result, count);

        // 현재 들어온 지점은 방문 처리 시킴
        alphaVisit[alphaBoard[y][x] - 'A'] = true;

        // 상 하 좌 우 값 탐색을 위한 반복문
        for (int i = 0; i < 4; i++) {
            // 현재 지점에서 갈 수 있는 좌표값 계싼
            int ny = y + dy[i];
            int nx = x + dx[i];

            // 상하좌우 격자에서 인덱스가 벗어나지 않으면서, 이동하고자 하는 좌표의 알파벳이 방문한적 없는 알파벳인 경우
            if (ny >= 0 && ny < R && nx >= 0 && nx < C
                    && !alphaVisit[alphaBoard[ny][nx] - 'A']) {
                // dfs 재호출
                dfs(ny, nx, count + 1);
            }
        }
        // 위 반복문을 통해 dfs 재귀호출이 이루어지지 않는다라는 것은 백 트래킹이 이루어 져야 한다는 것을 뜻함
        // 현재 좌표 방문을 false 처리
        alphaVisit[alphaBoard[y][x] - 'A'] = false;
    }
}