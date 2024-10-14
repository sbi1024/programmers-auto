class Solution {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        String[] splitStr = rsp.split("");
        for (String str : splitStr) {
            if (str.equals("0")) {
                sb.append("5");
            } else if (str.equals("2")) {
                sb.append("0");
            } else if (str.equals("5")) {
                sb.append("2");
            } 
        }
        return sb.toString();
    }
}