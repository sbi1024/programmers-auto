class Solution {
    public int solution(int order) {
        int result = 0;
        String orderStr = String.valueOf(order);
        String[] orderStrSplit = orderStr.split("");
        for (String str : orderStrSplit) {
            if (str.equals("3") || str.equals("6") || str.equals("9")) {
                result ++;
            }
        }
        return result;
    }
}