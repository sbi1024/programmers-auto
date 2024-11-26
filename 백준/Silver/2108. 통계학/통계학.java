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
        int maxValue = Integer.MIN_VALUE;
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            if (value > maxValue) {
                maxValue = value;
            }
        }

        Set<Integer> set = new TreeSet<>();
        for (Map.Entry<Integer, Integer> es : map.entrySet()) {
            if (es.getValue() == maxValue) {
                set.add(es.getKey());
            }
        }

        List<Integer> list = new ArrayList<>(set);
        if (list.size() > 1) {
            return list.get(1);
        } else {
            return list.get(0);
        }
    }
}