import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 보드 크기 입력
        String[] dimensions = br.readLine().split(" ");
        int N = Integer.parseInt(dimensions[0]);
        int M = Integer.parseInt(dimensions[1]);

        // 보드 입력
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int minPaint = Integer.MAX_VALUE; // 칠해야 할 최소 칸 수

        // 모든 8x8 체스판 구간 탐색
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                // 현재 (i, j)에서 시작하는 8x8 체스판의 최소 칠해야 할 칸 수 계산
                int paintCountW = countPaint(board, i, j, 'W'); // 'W' 시작
                int paintCountB = countPaint(board, i, j, 'B'); // 'B' 시작

                // 최소값 갱신
                minPaint = Math.min(minPaint, Math.min(paintCountW, paintCountB));
            }
        }

        // 결과 출력
        System.out.println(minPaint);
    }

    // 특정 8x8 체스판에서 칠해야 하는 칸 수 계산
    private static int countPaint(char[][] board, int startRow, int startCol, char startColor) {
        int count = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // 체스판의 현재 위치의 색상
                char currentColor = board[startRow + i][startCol + j];

                // 체스판의 올바른 색상 계산
                char expectedColor = ((i + j) % 2 == 0) ? startColor : (startColor == 'W' ? 'B' : 'W');

                // 현재 위치의 색상이 올바르지 않다면 칠해야 함
                if (currentColor != expectedColor) {
                    count++;
                }
            }
        }

        return count;
    }
}
