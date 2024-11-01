class Solution {
    public int solution(int num, int k) {
        String numStr = String.valueOf(num);
        String numK = String.valueOf(k);
        int result = numStr.indexOf(numK);
        return result == -1 ? -1 : result + 1;
    }
}