import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int forCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < forCount; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            long combResult = comb(first, second);
            sb.append(combResult).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 결국엔 강 서쪽에 다리가 무조건 존재해야 하기에,
    // 동쪽으로부터의 서쪽만큼의 조합을 구하는 문제로 귀결
    // 조합의 공식은 nCr
    static long comb(int first, int second) {
        // 최악의 경우 30개 중에 29개를 뽑아야 하는 경우의 수도 존재하기에
        // BigInteger 를 사용할 수 도 있지만, 보다 빠르게 해결하기 위한 최적화된 해의 방법을 사용한다.
        
        long result = 1;
        // 분자 계산, 분모 계산
        // 만약 30 개중에 5개를 뽑아야 하는 조합의 수를 계싼해야 한다면,
        // 다음과 같은 식이 성립된다.
        
        // 30!
        // 25! * 5!
        // 그렇다면 분자에서는 30부터 26까지의 곱셈만 진행되고, 분모는 1부터 5까지의 곱셈만 진행되면 된다.
        // 아래 코드는 위 과정을 함축시킨 코드이다.
        for (int i = 0; i < first; i++) {
            result *= second - i;
            result /= i + 1;
        }
        return result;
    }
}