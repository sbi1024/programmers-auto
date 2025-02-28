import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] sudoku = new int[9][9]; // 스도쿠 2차원 배열 선언
    static List<Node> zeroList = new ArrayList<>(); // 0인 좌표, 즉 값을 할당해야하는 좌표값들을 담을 변수 선언
    static boolean flag; // 백트래킹 때문에 조건을 만족하는 경우의 수까지 도달하더라도, 탐색을 계속해서 진행함, 그렇기에 마족하는 경우가 생기는 경우 탈출 조건 변수 선언


    public static void main(String[] args) throws IOException {
        // 입력 스트림 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 변수 값 할당
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 0) zeroList.add(new Node(i, j));
                sudoku[i][j] = value;
            }
        }
        // 탐색 시작
        dfs(0);
        // 자원 반납
        br.close();
    }

    static void printResult() throws IOException {
        // 출력 스트림 생성
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 결과값 출력을 위한 StringBuilder 처리
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) sb.append(sudoku[i][j]).append(" ");
            sb.append("\n");
        }
        // 결과값 출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void dfs(int depth) throws IOException {
        // kick > flag 가 필요한 이유가 중요.
        if (flag) return;

        // 기저조건 설정 > 0 부터 시작되기에, zeroList 의 size 만큼 크기가 되었을떄는
        // 이미 모든 zero 좌표에 대해서 처리가 되었다고 볼 수 있음
        if (depth == zeroList.size()) {
            printResult();
            flag = true;
            return;
        }

        // 작성해야하는 스도쿠 값 좌표 추출
        Node node = zeroList.get(depth);
        int curY = node.y;
        int curX = node.x;

        // 숫자 방문 여부 변수 선언
        boolean[] visitNumber = new boolean[10];
        // 1. 현재 위치에 해당하는 좌표의 행에 존재하는 숫자 방문처리
        checkRow(curY, visitNumber);
        // 2 .현재 위치에 해당하는 좌표의 열에 존재하는 숫자 방문처리
        checkCol(curX, visitNumber);
        // 3. 현재 위치에 해당하는 좌표의 3곱하기에 존재하는 숫자 방문처리
        checkThree(curY, curX, visitNumber);

        // 1 ~ 9 까지의 숫자를 하나씪 넣어봄
        for (int i = 1; i <= 9; i++) {
            if (!visitNumber[i]) {
                sudoku[curY][curX] = i;
                dfs(depth + 1);
                sudoku[curY][curX] = 0;
            }
        }
    }

    // 각 좌표의 행에 위차하는곳에 존재하는 숫자 확인
    static void checkRow(int y, boolean[] visitNumber) {
        for (int i = 0; i < 9; i++) {
            int value = sudoku[y][i];
            if (value != 0) visitNumber[value] = true;
        }
    }

    // 각 좌표의 열에 위차하는곳에 존재하는 숫자 확인
    static void checkCol(int x, boolean[] visitNumber) {
        for (int i = 0; i < 9; i++) {
            int value = sudoku[i][x];
            if (value != 0) visitNumber[value] = true;
        }
    }

    // 각 좌표의 3 곱하기 3에  위차하는곳에 존재하는 숫자 확인
    static void checkThree(int y, int x, boolean[] visitNumber) {
        int ny = (y / 3) * 3;
        int nx = (x / 3) * 3;
        for (int i = ny; i < ny + 3; i++) {
            for (int j = nx; j < nx + 3; j++) {
                int value = sudoku[i][j];
                if (value != 0) visitNumber[value] = true;
            }
        }
    }

    // 좌표의 위치를 담을 내부 클래스 선언
    static class Node {
        int y; // 행
        int x; // 열

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}