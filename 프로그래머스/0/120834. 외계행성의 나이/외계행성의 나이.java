class Solution {
    public String solution(int age) {
        String[] strArr = new String[] {"a","b","c","d","e","f","g","h","i","j"};
        String[] strSplit = String.valueOf(age).split("");
        StringBuilder sb = new StringBuilder();
        for (String str : strSplit) {
            sb.append(strArr[Integer.parseInt(str)]);
        }
        return sb.toString();
    }
}