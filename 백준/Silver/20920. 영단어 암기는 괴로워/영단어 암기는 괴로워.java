import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int forCount = Integer.parseInt(st.nextToken());
        int minLength = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < forCount; i++) {
            String line = br.readLine();
            if (line.length() >= minLength) {
                map.put(line, map.getOrDefault(line, 0) + 1);
            }
        }

        /**
         * 자주 나오는 단어일수록 앞에 배치한다.
         * 해당 단어의 길이가 길수록 앞에 배치한다.
         * 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
         */
        ArrayList<String> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> {
            Integer freq1 = map.get(o1);
            Integer freq2 = map.get(o2);
            if (!Objects.equals(freq1, freq2)) {
                if (freq1 < freq2) {
                    return 1;
                } else if (freq1 > freq2) {
                    return -1;
                } else {
                    return 0;
                }
            }
            if (o1.length() != o2.length()) {
                if (o1.length() < o2.length()) {
                    return 1;
                } else if (o1.length() > o2.length()) {
                    return -1;
                } else {
                    return 0;
                }
            }
            return o1.compareTo(o2);
        });

        for (String l : list) {
            sb.append(l).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}