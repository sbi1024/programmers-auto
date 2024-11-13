import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        String[] getCartSplit = br.readLine().split(" ");
        int findCount = Integer.parseInt(br.readLine());
        int[] result = new int[findCount];
        String[] findCardSplit = br.readLine().split(" ");

        Map<Integer, Boolean> cardMap = new HashMap<>();
        Map<Integer, Boolean> findMap = new LinkedHashMap<>();

        for (String getCard : getCartSplit) cardMap.put(Integer.parseInt(getCard), true);
        for (String findCard : findCardSplit) findMap.put(Integer.parseInt(findCard), true);

        int index = 0;
        for (Integer findKey : findMap.keySet()) {
            Boolean check = cardMap.getOrDefault(findKey, false);
            if (check) {
                result[index] = 1;
            }
            index++;
        }

        StringBuilder sb = new StringBuilder();
        for (int value : result) {
            sb.append(value).append(" ");
        }
        System.out.println(sb);
    }
}
