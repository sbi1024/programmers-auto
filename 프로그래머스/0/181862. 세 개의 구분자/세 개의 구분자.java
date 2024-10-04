import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String[] solution(String myStr) {
        List<String> list = new ArrayList<>();
        String replaceAllMyStr = myStr.replaceAll("[a-c]", " ");
        String[] replaceAllMyStrSplit = replaceAllMyStr.split(" ");
        for (int i = 0; i < replaceAllMyStrSplit.length; i++) {
            if (!replaceAllMyStrSplit[i].isEmpty()) {
                list.add(replaceAllMyStrSplit[i]);
            }
        }

        if (list.size() == 0) {
            list.add("EMPTY");
            return list.stream().toArray(String[]::new);
        } else {
            return list.stream().toArray(String[]::new);
        }
    }
}