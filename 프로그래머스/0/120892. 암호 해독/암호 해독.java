class Solution {
    public String solution(String cipher, int code) {
        StringBuilder sb = new StringBuilder();
        char[] chArr = cipher.toCharArray();
        for (int i = 0 ; i < chArr.length; i++) {
            if ((i +1) % code == 0) {
                sb.append(chArr[i]);
            }
        }
        return sb.toString();
    }
}