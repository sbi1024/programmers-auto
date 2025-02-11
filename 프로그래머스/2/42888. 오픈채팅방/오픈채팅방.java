import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};

        Map<String, String> map = new HashMap<>();
        StringTokenizer st;
        for (String rec : record) {
            st = new StringTokenizer(rec);
            String input1 = st.nextToken(); // Enter, Leave, Change
            String input2 = st.nextToken(); // 아이디
            String input3; // 닉네임
            if (input1.equals("Enter")) {
                input3 = st.nextToken();
                map.put(input2, input3);
            } else if (input1.equals("Leave")) {
                map.put(input2, map.get(input2));
            } else {
                input3 = st.nextToken();
                map.put(input2, input3);
            }
        }

        List<String> list = new ArrayList<>();
        for (String rec : record) {
            st = new StringTokenizer(rec);
            String input1 = st.nextToken(); // Enter, Leave, Cahnge
            String input2 = st.nextToken(); // 아이디
            String nickname = map.get(input2);
            String result;
            if (input1.equals("Enter")) {
                result = nickname + "님이 들어왔습니다.";
                list.add(result);
            } else if (input1.equals("Leave")) {
                result = nickname + "님이 나갔습니다.";
                list.add(result);
            }
        }

        answer = new String[list.size()];
        list.toArray(answer);

        return answer;
    }
}