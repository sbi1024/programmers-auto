import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        Queue<String> cardQueue1 = new ArrayDeque<>();
        Queue<String> cardQueue2 = new ArrayDeque<>();
        Queue<String> goalQueue = new ArrayDeque<>();

        for (String card : cards1) cardQueue1.offer(card);
        for (String card : cards2) cardQueue2.offer(card);
        for (String go : goal) goalQueue.offer(go);

        while (!goalQueue.isEmpty()) {
            String stand = goalQueue.peek();
            String peek1 = cardQueue1.peek();
            String peek2 = cardQueue2.peek();
            if (peek1 == null) peek1 = "";
            if (peek2 == null) peek2 = "";
            if (peek1.equals(stand)) cardQueue1.poll();
            else if (peek2.equals(stand)) cardQueue2.poll();
            else {
                answer = "No";
                break;
            }
            goalQueue.poll();
        }
        return answer;
    }
}