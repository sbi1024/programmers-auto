import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 말처럼 움직일 수 있는 횟수, 행, 열 값
    static int K, W, H;
    static int[][] map;
    static boolean[][][] visitMap;
    static int[] dy = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1}; // 상 하 좌 우
    static int[] hdy = {-2, -2, -1, -1, 2, 2, 1, 1}; // 말의 움직임
    static int[] hdx = {-1, 1, -2, 2, -1, 1, -2, 2}; // 말의 움직임

    public static void main(String[] args) throws IOException {
        // 입출력 스트림 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 변수 초기화
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visitMap = new boolean[H][W][K + 1];

        // map 데이터 할당
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // bfs 호출
        int result = bfs();

        // 결과값 출력
        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        visitMap[0][0][K] = true;
        queue.offer(new Node(0, 0, K, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int y = poll.y;
            int x = poll.x;
            int distance = poll.distance;

            // 기저 조건
            if (y == H - 1 && x == W - 1) {
                return distance;
            }

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || visitMap[ny][nx][poll.k])
                    continue;

                visitMap[ny][nx][poll.k] = true;
                queue.offer(new Node(ny, nx, poll.k, poll.distance + 1));
            }

            // 말의 움직임
            if (poll.k > 0) { // K가 남아있을 때만 사용 가능
                for (int i = 0; i < 8; i++) {
                    int ny = poll.y + hdy[i];
                    int nx = poll.x + hdx[i];

                    if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || visitMap[ny][nx][poll.k - 1])
                        continue;

                    visitMap[ny][nx][poll.k - 1] = true;
                    queue.offer(new Node(ny, nx, poll.k - 1, poll.distance + 1));
                }
            }
        }

        return -1;
    }

    static class Node {
        int y;
        int x;
        int k;
        int distance;


        public Node(int y, int x, int k, int distance) {
            this.y = y;
            this.x = x;
            this.k = k;
            this.distance = distance;
        }
    }
}