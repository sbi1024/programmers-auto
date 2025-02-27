import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 연산자의 순열을 구해야 한다.
// 연산자의 순열의 경우의 수 마다 결과값을 계산해서 최대값, 최소값을 갱신한다.

public class Main {
    static int N; // N개로 이어진 수열 (EX) 1, 2 ...)
    static int[] numberArray; // N개로 이어진 수열을 담는 배열

    // 각 연산자마다 배열을 생성하여 사용하는거보다, 가변 리스트로 담아서 사용하는게 낫겟다는 판단을 함
    static List<Integer> operationList = new ArrayList<>(); // 연산자를 담는 list
    static List<Integer> selectOperationList = new ArrayList<>(); // 선택된 연산자를 담는 list
    static boolean[] operationVisit; // 연산자 방문 여부 확인 배열

    // 결과값으로 출력할 최대값과 최소값 변수 선언
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // 입추력 스트림 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 입력값 할당
        N = Integer.parseInt(br.readLine());
        numberArray = new int[N];
        // numberArray 값 할당 (피연산자)
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) numberArray[i] = Integer.parseInt(st.nextToken());

        // 연산자 기호 값 할당
        st = new StringTokenizer(br.readLine());

        // 연산 횟수 계산
        int plusCount = Integer.parseInt(st.nextToken());
        int minusCount = Integer.parseInt(st.nextToken());
        int multiCount = Integer.parseInt(st.nextToken());
        int modCount = Integer.parseInt(st.nextToken());

        // list 에 add ( + : 0, - : 1, * : 2, / : 3)
        for (int i = 0; i < plusCount; i++) operationList.add(0);
        for (int i = 0; i < minusCount; i++) operationList.add(1);
        for (int i = 0; i < multiCount; i++) operationList.add(2);
        for (int i = 0; i < modCount; i++) operationList.add(3);

        // 방문 여부 확인용 변수 선언
        operationVisit = new boolean[operationList.size()];

        // operationList 의 순열 경우의 수 구하기
        // 구하고자 하는 경우의 수는 N개 중에 N-1개 고르기
        perm(0);

        // 결과값 포맷 맞추기 > 최대값 (줄바꿈) 최소값 형식
        sb.append(maxValue).append("\n");
        sb.append(minValue).append("\n");

        // 결과값 출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 순열 dfs
    public static void perm(int depth) {
        // 기저조건 설정
        if (depth == N - 1) {
            // 연산 결과 계산 실행
            calcMinMaxValue();
            return;
        }

        // 연산자를 뽑는 반복문
        for (int i = 0; i < operationList.size(); i++) {
            if (!operationVisit[i]) {
                selectOperationList.add(operationList.get(i));
                operationVisit[i] = true;
                perm(depth + 1);
                operationVisit[i] = false;
                selectOperationList.remove(selectOperationList.size() - 1);
            }
        }
    }

    // 순열로 선택된 연산자 계산처리
    static void calcMinMaxValue() {
        int result = numberArray[0];


        // 마지막 연산과정은 제외함
        for (int i = 1; i < numberArray.length - 1; i++) {
            int number = numberArray[i];
            int operation = selectOperationList.get(i - 1);
            result = calc(result, number, operation);
        }
        // 마지막 연산과정 처리
        result = calc(result, numberArray[numberArray.length - 1], selectOperationList.get(selectOperationList.size() - 1));

        // 최대값 최소값 계산
        maxValue = Math.max(result, maxValue);
        minValue = Math.min(result, minValue);
    }

    static int calc(int number1, int number2, int operation) {
        // 리턴값 선언
        int result = 0;
        // 연산자 마다 다르게 처리
        switch (operation) {
            // 덧셈
            case 0:
                result = number1 + number2;
                break;
            // 뺄셈
            case 1:
                result = number1 - number2;
                break;
            // 곱셈
            case 2:
                result = number1 * number2;
                break;
            // 나눗셈
            case 3:
                result = number1 / number2;
                break;
            default:
                break;
        }
        // 결과값 반환
        return result;
    }
}
