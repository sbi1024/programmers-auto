class Solution {
    public String solution(String my_string, int num1, int num2) {
        char[] chArr = my_string.toCharArray();
        char chNum1 = chArr[num2];
        char chNum2 = chArr[num1];
        chArr[num1] = chNum1;
        chArr[num2] = chNum2;
        return String.valueOf(chArr);
    }
}