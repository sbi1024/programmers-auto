import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int N; // 입력값으로 주어지는 인원의 수
    static int[] people; // 인원 (N)
    static int[] selectPeople; // 선택된 인원 (N / 2)
    static List<Integer> notSelectPeople = new ArrayList<>(); // 비 선택된 인원 (N / 2)
    static boolean[] visitPeople; // 방문한 인원 (N)
    static int[][] peoplePowerMap; // 각 인원이 시너지가 존재하는 능력치를 담는 map

    static int result = Integer.MAX_VALUE; // 결과값 변수 선언

    public static void main(String[] args) throws IOException {
        // 입출력 스트림 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 변수 값 할당
        N = Integer.parseInt(br.readLine());
        people = new int[N];
        selectPeople = new int[N / 2];
        visitPeople = new boolean[N];
        peoplePowerMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            people[i] = i;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                peoplePowerMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 주어진 인원의 조합 계산 (N개 중에 N / 2를 뽑음)
        peopleComb(0, 0);


        // 결과값 출력 및 자원 반환
        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    // 뽑을수 있는 사람의 조합을 구함
    static void peopleComb(int depth, int startIndex) {
        // 기저 조건 설정 > 뽑아야 하는 인원 수에 도달할 경우 종료
        if (depth == selectPeople.length) {
            // 여기서 반대로 뽑히지 않은 인원과의 차이값을 계산
            initNotSelectPeople();
            // 최소값 갱신
            updateMinValue();
            // 기저 조건 완료 = 메서드 종료 처리
            return;
        }

        // 조합 반복문 dfs
        for (int i = startIndex; i < N; i++) {
            if (!visitPeople[i]) {
                selectPeople[depth] = people[i];
                visitPeople[i] = true;
                peopleComb(depth + 1, i + 1);
                visitPeople[i] = false;
            }
        }
    }

    static void initNotSelectPeople() {
        // 혹시 이전에 사용된 데이터가 있을수 있기에 clear 처리
        notSelectPeople.clear();
        // selectPeople 이 아닌 배열을 만듬
        for (int i = 0; i < visitPeople.length; i++) {
            if (!visitPeople[i]) notSelectPeople.add(i);
        }
    }

    static void updateMinValue() {
        // 기존에 사용한 List 값을 비움
        notSelectPeople.clear();

        // selectPeople 이 아닌 배열을 만듬
        for (int i = 0; i < visitPeople.length; i++) {
            if (!visitPeople[i]) notSelectPeople.add(i);
        }

        // selectPeople, notSelectPeople 로 두가지 팀은 나누어 졌음
        // 다만 해당 변수에 대해서 2가지를 뽑는 다는 조합의 경우의 수를 구해서 합산한 값을 각각 구해야 함
        int abs = Math.abs(calcSelectPeople() - calcNotSelectPeople());
        // 도출된 값 갱신
        if (abs < result) result = abs;
    }

    // 선택된 인원의 능력치 합 계산
    static int calcSelectPeople() {
        int sum = 0;
        for (int i = 0; i < selectPeople.length; i++) {
            for (int j = i + 1; j < selectPeople.length; j++) {
                int first = selectPeople[i];
                int second = selectPeople[j];
                sum += peoplePowerMap[first][second] + peoplePowerMap[second][first];
            }
        }
        return sum;
    }

    // 비 선택된 인원의 능력치 합 계산
    static int calcNotSelectPeople() {
        int sum = 0;
        int size = notSelectPeople.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int first = notSelectPeople.get(i);
                int second = notSelectPeople.get(j);
                sum += peoplePowerMap[first][second] + peoplePowerMap[second][first];
            }
        }
        return sum;
    }
}