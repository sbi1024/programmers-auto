class Solution {
    public int solution(String my_string) {
        char[] charArray = my_string.replaceAll("[A-z]", "").toCharArray();
        int sum = 0 ;
        for (char ch : charArray) {
            sum += (ch - '0');
        }
        return sum;
    }
}