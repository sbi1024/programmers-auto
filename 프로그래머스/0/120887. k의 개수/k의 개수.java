class Solution {
    public int solution(int i, int j, int k) {
        int count = 0;
        for (int first = i ; first <= j; first++) {
            String[] split = String.valueOf(first).split("");
            for (String str : split) {
                if (str.equals(String.valueOf(k))) {
                    count ++;
                }   
            }
        }
        return count;
    }
}