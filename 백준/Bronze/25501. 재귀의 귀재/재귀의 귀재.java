import java.io.*;

public class Main {
    static int recursionCount; // 재귀 호출 횟수 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            recursionCount = 0; // 호출 횟수 초기화
            int result = isPalindrome(str, 0, str.length() - 1);
            sb.append(result).append(" ").append(recursionCount).append("\n");
        }

        System.out.print(sb.toString());
    }

    // 재귀적으로 회문을 판별
    private static int isPalindrome(String str, int left, int right) {
        recursionCount++; // 재귀 호출 횟수 증가

        if (left >= right) {
            // 기저 조건: 문자열이 비었거나 한 글자만 남았을 때
            return 1; // 회문
        } else if (str.charAt(left) != str.charAt(right)) {
            // 첫 번째 문자와 마지막 문자가 다를 때
            return 0; // 회문 아님
        } else {
            // 첫 번째 문자와 마지막 문자가 같으면, 나머지 문자열 검사
            return isPalindrome(str, left + 1, right - 1);
        }
    }
}
