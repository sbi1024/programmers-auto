import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int row, col; // 격자판의 행과 열의 수
    static Shark[][] sharkMap; // 상어가 존재하는 위치를 기록하는 변수
    static int sharkTotalSize; // 결과값으로 도출할 낚시왕이 잡은 상어의 총 크기
    static int moveX = -1; // 낚시꾼이 위치한 현재 x 위치
    static int moveY = 0; // 낚시꾼이 위치한 현재 y 위치

    public static void main(String[] args) throws IOException {
        // 입력값을 받을 stream 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken()); // 격자판의 행의 개수
        col = Integer.parseInt(st.nextToken()); // 격자판의 열의 개수
        int sharkCount = Integer.parseInt(st.nextToken()); // 격자판에 존재하는 상어의 개수

        if (sharkCount != 0) {
            sharkMap = new Shark[row][col]; // 상어가 어디에 존재하는지 뱅려 선언
            for (int i = 0; i < sharkCount; i++) {
                // 입력값 파싱
                st = new StringTokenizer(br.readLine());
                int indexX = Integer.parseInt(st.nextToken()); // x 좌표
                int indexY = Integer.parseInt(st.nextToken()); // y 좌표
                int speed = Integer.parseInt(st.nextToken()); // 속력
                int direction = Integer.parseInt(st.nextToken()); // 방향
                int size = Integer.parseInt(st.nextToken()); // 크기
                // 값 할당
                sharkMap[indexX - 1][indexY - 1] = new Shark(speed, direction, size);
            }
            // 문제에서 주어진 조건 메서드 실행
            simulation();
        }

        // 결과값 출력
        bw.write(sharkTotalSize + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void simulation() {
        // 조건문 변경이 필요할 수도 있음.
        while (moveX != col - 1) {
            // 1. 낚시왕이 오른쪽으로 한칸 이동한다.
            moveX++;
            // 2-1. 낚시왕이 있는 현재 위치에서의 상어 중에서 가장 땅과 가까운 상어를 잡는다.
            for (int i = 0; i < row; i++) {
                // 땅과 가장 가까운 상어
                Shark shark = sharkMap[i][moveX];
                // 만약 존재하지 않는다면 다음 값을 찾는다
                if (shark == null) continue;
                // 2-2. 존재한다면, 해당 위치의 상어를 격자판에서 지운다.
                sharkMap[i][moveX] = null;
                // 그 후 상어는 낚시왕이 잡은것이니, 해당 값을 sharkTotalSize 에 더한다.
                sharkTotalSize += shark.getSize();
                // break (찾으면 더이상 진행하지 않음)
                break;
            }
            // 3. 상어가 이동한다.
            moveShark();
        }
    }

    // 상어가 이동할떄의 시물레이션 메서드
    static void moveShark() {
        // 1. 상어는 주어진 속도로 이동한다.
        // 2. 상어가 이동하려고 하는 칸이 격자판의 경계를 넘는 경우 방향을 반대로 바꾼 후 이동한다.
        // 3. 상어가 이동을 마친 후에, 한칸에 상어가 두마리 이상인 경우, 크기가 가장 큰 상어가 나머지 상어를 모두 잡아먹는다.
        // 방향은 1 : 위, 2 : 아래, 3 : 오른쪽, 4 : 왼쪽

        // 임시 배열 생성
        Shark[][] newSharkMap = new Shark[row][col];

        // 반복문을 돌면서, 상어를 이동시킴 (차후 상어가 위치한 좌표값만 큐에 담아두고 메서드 수정을 하는게 좋아보이기는 함)
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                Shark shark = sharkMap[y][x];
                // null 이라는 것은 상어가 미존재
                if (shark == null) continue;
                // null 이 아닌 경우, 상어가 존재, 해당 상어 격자를 벗어났는지 확인 및, 방향성 체크

                int direction = shark.getDirection(); // 상어의 방향성
                int speed = shark.getSpeed(); // 상어의 속력
                int plusY = y;
                int plusX = x;

                // *** 별도 처리 부분 ***
                for (int i = 0; i < speed; i++) {
                    if (direction == 1) { 
                        // 위
                        if (plusY == 0) {
                            direction = 2; // 아래로 변경
                        } else {
                            plusY--;
                            continue; 
                        }
                        plusY++;
                    }
                    else if (direction == 2) {
                        // 아래
                        if (plusY == row - 1) {
                            direction = 1; // 위로 변경
                        } else {
                            plusY++;
                            continue;
                        }
                        plusY--;
                    }
                    else if (direction == 3) {
                        // 오른쪽
                        if (plusX == col - 1) {
                            direction = 4; // 왼쪽으로 변경
                        } else {
                            plusX++;
                            continue;
                        }
                        plusX--;
                    }
                    else { 
                        // 왼쪽
                        if (plusX == 0) {
                            direction = 3; // 오른쪽으로 변경
                        } else {
                            plusX--;
                            continue;
                        }
                        plusX++;
                    }
                }
                // *** 공통 처리 부분 ***
                shark.setDirection(direction);
                // 해당 위치에 이미 다른 상어가 있으면 크기 비교
                if (newSharkMap[plusY][plusX] == null) {
                    newSharkMap[plusY][plusX] = shark; // 그냥 넣음
                } else {
                    // 이미 있으면 크기 비교
                    if (newSharkMap[plusY][plusX].getSize() < shark.getSize()) {
                        newSharkMap[plusY][plusX] = shark;
                    }
                }
            }
        }
        // 이동 처리된 상어의 배열을 기존 전역변수에 담음
        sharkMap = newSharkMap;
    }


    // 상어 객체가 가지고 있는 정보를 담을 class 선언
    static class Shark {
        int speed; // 속력
        int direction; // 방향
        int size; // 크기

        // 생성자를 통한 객체 생성
        public Shark(int speed, int direction, int size) {
            this.speed = speed;
            this.direction = direction;
            this.size = size;
        }

        // 출력값을 확인하기 위한 오버라이딩
        @Override
        public String toString() {
            return "Shark{" +
                    "speed=" + speed +
                    ", direction=" + direction +
                    ", size=" + size +
                    '}';
        }

        // 메서드로 값 반환

        public int getSpeed() {
            return speed;
        }

        // 메서드로 값 반환
        public int getDirection() {
            return direction;
        }

        // 방향은 격자를 벗어난다면 바꿔져야 함
        public void setDirection(int direction) {
            this.direction = direction;
        }

        // 메서드로 값 반환
        public int getSize() {
            return size;
        }
    }
}