import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        int[] array = new int[count];
        Map<Integer, Integer> map = new HashMap<>(); // 최빈값 구하기

        int sum = 0;
        for (int i = 0; i < count; i++) {
            int input = Integer.parseInt(br.readLine());
            sum += input;
            array[i] = input;
            map.put(input, map.getOrDefault(input, 0) + 1);
        }
        Arrays.sort(array);

        // 산술평균 값
        sb.append(Math.round((double) sum / count)).append("\n");
        // 중앙값
        sb.append(array[array.length / 2]).append("\n");
        // 최빈값
        sb.append(findMode(map)).append("\n");
        // 범위
        sb.append(array[array.length - 1] - array[0]).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int findMode(Map<Integer, Integer> map) {
        int maxValue = Integer.MIN_VALUE; // 최대 빈도수
        List<Integer> candidates = new ArrayList<>(); // 최빈값 후보들

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value > maxValue) {
                maxValue = value; // 더 높은 빈도수 발견
                candidates.clear(); // 기존 후보 초기화
                candidates.add(key);
            } else if (value == maxValue) {
                candidates.add(key); // 같은 빈도수라면 추가
            }
        }

        // 후보를 정렬하여 두 번째 값을 반환
        Collections.sort(candidates);
        return candidates.size() > 1 ? candidates.get(1) : candidates.get(0);
    }

}