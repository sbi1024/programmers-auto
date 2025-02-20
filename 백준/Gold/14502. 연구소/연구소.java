import java.io.*;
import java.util.*;

public class Main {
    static int N, M; // 격자의 행과 열 
    static int[][] map; // 격자판 2차원 배열
    static List<Node> zeroList = new ArrayList<>(); // 조합을 구해야하는데, 벽을 세울수 있는 위치 Node 를 리스트 변수로 관리
    static List<Node> virusList = new ArrayList<>();
    static boolean[] zeroVisit;
    static Node[] selectZero = new Node[3];
    static int[] dy = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1}; // 상 하 좌 우
    static int result = Integer.MIN_VALUE; // 안전지대 값


    public static void main(String[] args) throws IOException {
        // 입출력 스트림 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 행의 값 할당
        M = Integer.parseInt(st.nextToken()); // 열의 값 할당

        map = new int[N][M]; // 격자판 초기화
        // map 데이터 할당
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                // 만약 빈 공간이라면, 이부분에 벽을 세울수 있으니 list 에 담는다.
                if (value == 0) zeroList.add(new Node(i, j));
                else if (value == 2) virusList.add(new Node(i, j));
            }
        }

        // 방문 배열 초기화
        zeroVisit = new boolean[zeroList.size()];

        // 조합을 찾는다
        comb(0, 0);

        // 결과값 출력
        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    // 사실상 dfs 다만,기저조건에서 bfs 호출
    static void comb(int depth, int startIndex) {
        if (depth == 3) {
            // 여기서 bfs 호출하고 호출된 메서드에서 result 비교
            bfs();
            return;
        }
        // 방문 여부에 따라 호출
        for (int i = startIndex; i < zeroList.size(); i++) {
            if (!zeroVisit[i]) {
                selectZero[depth] = zeroList.get(i);
                zeroVisit[i] = true;
                comb(depth + 1, i + 1);
                zeroVisit[i] = false;
            }
        }
    }

    // 바이러스가 전염될때 어떻게 map 이 변화될지 확인
    static void bfs() {
        // 새로운 배열 생성 (처음에 얕은복사로 했다가, 깊은복사로 코드 변경했음)
        // 주소값만 새롭게 옮기면 안됨, 원본 map이 변경됨
        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        // 새로운 copyMap 에 조합에서 선택된 벽을 생성해봄
        for (Node node : selectZero) {
            copyMap[node.y][node.x] = 1;
        }
        // bfs 에 사용할 큐 생성
        Queue<Node> queue = new ArrayDeque<>(virusList);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            // 사방 탐색 필요
            for (int i = 0; i < 4; i++) {
                int ny = poll.y + dy[i];
                int nx = poll.x + dx[i];
                // 격자판을 벗어나면 전파 못함
                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                // 벽이라면 전염 못함, 근데 바이러스도 전염 못시키나 ?
                if (copyMap[ny][nx] == 1 || copyMap[ny][nx] == 2) continue;
                // 2로 변경처리 후, 전염된 위치라면 queue 에 담는다.
                copyMap[ny][nx] = 2;
                queue.offer(new Node(ny, nx));
            }
        }
        // 안전지대 확인
        checkSafeZone(copyMap);
    }

    static void checkSafeZone(int[][] copyMap) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    sum++;
                }
            }
        }
        
        result = Math.max(result, sum);
    }

    // Node 객체 선언
    static class Node {
        int y, x;

        // 생성자 호출
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }
}