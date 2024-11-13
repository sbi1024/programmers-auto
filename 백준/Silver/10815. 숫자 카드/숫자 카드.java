import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 입력: 가지고 있는 카드의 개수 (사용하지 않음)
        br.readLine();
        String[] getCartSplit = br.readLine().split(" ");
        
        // 가지고 있는 카드를 Set에 저장
        Set<Integer> cardSet = new HashSet<>();
        for (String card : getCartSplit) {
            cardSet.add(Integer.parseInt(card));
        }

        // 두 번째 입력: 찾아야 할 카드의 개수 (사용하지 않음)
        br.readLine();
        String[] findCardSplit = br.readLine().split(" ");

        // 결과를 StringBuilder에 바로 추가
        StringBuilder sb = new StringBuilder();
        for (String findCard : findCardSplit) {
            int card = Integer.parseInt(findCard);
            sb.append(cardSet.contains(card) ? 1 : 0).append(" ");
        }

        // 최종 출력
        System.out.println(sb);
    }
}
