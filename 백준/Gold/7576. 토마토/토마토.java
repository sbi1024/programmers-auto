import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int first;
    static int second;
    static Queue<int[]> queue = new LinkedList<>();
    static int[][] array;
    static int[][] days;

    // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        // 입츨력 스트림 변수 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력받는 문자열 자르기 위한 StringTokenizer 객체 생성
        StringTokenizer st;

        // 입력값 자르기
        st = new StringTokenizer(br.readLine());
        first = Integer.parseInt(st.nextToken()); // 행
        second = Integer.parseInt(st.nextToken()); // 열
        array = new int[second][first]; // 토마토 상자 배열
        days = new int[second][first]; // 토마토 상자에서 익은 토마토가 언제 익는지 체크하기 위한 변수 선언

        // 입력값 받은것을 토마토 상자에 값을 넣음
        for (int i = 0; i < second; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < first; j++) {
                int value = Integer.parseInt(st.nextToken());
                array[i][j] = value;
                // 만약에 익은 토마토 값이라면
                if (value == 1) {
                    // bfs 에서 탐색하기 위한 익은 토마토의 위치 좌표값을 넣음
                    queue.add(new int[]{i, j});
                    // 익은 토마토는 0일로 설정
                    // 차후에 bfs 로 상하좌우 전염시키면서 몇일쨰 날짜에 익게되었는지 마킹
                    days[i][j] = 0;
                } else if (value == 0) {
                    // 익지않은 토마토니까 일단 -1로 할당함
                    // 나중에 어차피 bfs 에서 몇일에 익은 토마토인지 날짜값을 할당함
                    days[i][j] = -1;
                }
            }
        }

        // bfs 메서드 호출
        int result = bfs();

        // 결과값 출력
        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs() {
        // bfs 의 기본 뼈대, 반복문을 순회하면서 큐에 담긴 익은 토마토의 좌표값을 꺼내서 상하 좌우값을 전염시킴
        while (!queue.isEmpty()) {
            // 큐에서 값을 꺼내기
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            // 반복문을 통해 상하좌우 값 계산
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 만약 2차원 배열에서 벗어나는 값이 아니거나, 익지않은 토마토인 경우는 따로 체크하지 않음
                if (nx >= 0 && nx < second && ny >= 0 && ny < first && days[nx][ny] == -1) {
                    queue.add(new int[]{nx, ny});
                    days[nx][ny] = days[x][y] + 1;
                }
            }
        }

        // 만약에 days 가 -1이 존재한다면, 익을수 없는 토마토가 존재한다고 판단.
        for (int i = 0; i < second; i++) {
            for (int j = 0; j < first; j++) {
                if (days[i][j] == -1) {
                    return -1;
                }
            }
        }

        // 이제 days 배열에서 가장 큰 값을 찾음
        int MAX_VALUE = Integer.MIN_VALUE;
        for (int i = 0; i < second; i++) {
            for (int j = 0; j < first; j++) {
                int value = days[i][j];
                if (MAX_VALUE < value) {
                    MAX_VALUE = value;
                }
            }
        }

        return MAX_VALUE;
    }
}