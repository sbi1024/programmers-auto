class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = my_string.toCharArray();
        for (char ch : charArray) {
            if (!(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}