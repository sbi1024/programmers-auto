import java.io.*;
import java.util.*;

public class Main {
    static int N; // 구역구 개수
    static int[] zoneArray;
    static int[] personArray; // 인구수 배열
    static boolean[][] linkArray; // 각 구역의 연결 상태 관리 배열
    static List<Integer> selectList = new ArrayList<>(); // 선택된 구역
    static List<Integer> notSelectList = new ArrayList<>(); // 선택된 구역

    static boolean[] visitArray; // 방문한 구역
    static int tempCount;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // 입출력 스트림 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 변수 값 할당
        N = Integer.parseInt(st.nextToken());
        zoneArray = new int[N];
        personArray = new int[N];
        visitArray = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < personArray.length; i++) {
            zoneArray[i] = i + 1;
            personArray[i] = Integer.parseInt(st.nextToken());
        }

        // 각 구역에 연결된 구역 체크
        linkArray = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int index = Integer.parseInt(st.nextToken());
                linkArray[i][index - 1] = true;
            }
        }

        // 1개의 조합부터 N - 1 까찌의 조합을 짜봄
        // N - 1은 전부 다 선택하는 조합이기에 해볼 필요가 없음 어차피 두구역으로 안나누어짐
        for (int i = 0; i < N - 1; i++) {
            tempCount = i + 1;
            comb(0);
        }

        if (result == Integer.MAX_VALUE) {
            result = -1;
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void comb(int startIndex) {
        if (tempCount == selectList.size()) {
            notSelectList.clear(); // 이전 결과 초기화
            for (int i = 1; i <= N; i++) { // 전체 구역에서 selectList에 없는 값 찾기
                if (!selectList.contains(i)) {
                    notSelectList.add(i);
                }
            }
            boolean check1 = check(selectList);
            boolean check2 = check(notSelectList);

            // 둘다 나누어진 두가지 구역이라면
            if (check1 && check2) {
                int result1 = 0;
                int result2 = 0;
                for (int i = 0; i < selectList.size(); i++) {
                    result1 += personArray[selectList.get(i) - 1];
                }

                for (int i = 0; i < notSelectList.size(); i++) {
                    result2 += personArray[notSelectList.get(i) - 1];
                }
                int abs = Math.abs(result1 - result2);
                result = Math.min(result, abs);
                return;
            }
            return;
        }

        for (int i = startIndex; i < N; i++) {
            if (!visitArray[i]) {
                selectList.add(i + 1);
                visitArray[i] = true;
                comb(i + 1);
                visitArray[i] = false;
                selectList.remove(selectList.size() - 1);
            }
        }
    }

    public static boolean check(List<Integer> list) {
        if (list.isEmpty()) return false;

        boolean[] tempVisit = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(list.get(0)); // 첫 번째 노드부터 시작
        tempVisit[list.get(0) - 1] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            count++;

            for (int i = 0; i < N; i++) {
                if (linkArray[poll - 1][i] && list.contains(i + 1) && !tempVisit[i]) {
                    queue.add(i + 1);
                    tempVisit[i] = true;
                }
            }
        }
        return count == list.size();
    }
}