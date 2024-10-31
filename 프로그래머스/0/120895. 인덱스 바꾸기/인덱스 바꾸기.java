class Solution {
    public String solution(String my_string, int num1, int num2) {
        StringBuilder sb = new StringBuilder();
        char numStr1 = my_string.charAt(num1);
        char numStr2 = my_string.charAt(num2);
        
        char[] chArr = my_string.toCharArray();
        for (int i = 0 ; i < chArr.length; i++) {
            if (i == num1) {
                sb.append(numStr2);
            } 
            else if (i == num2) {
                sb.append(numStr1);
            } else {
                sb.append(chArr[i]);
            }
        }
        
        return sb.toString();
    }
}