import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        String[] strArray = my_string.replaceAll("[a-z]", "").split("");
        int[] result = new int[strArray.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(strArray[i]);
        }
        Arrays.sort(result);
        return result;
    }
}