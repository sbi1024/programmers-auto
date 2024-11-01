class Solution {
    public int solution(String my_string) {
        String[] splitStr = my_string.split(" ");
        int sum = Integer.parseInt(splitStr[0]);
        for (int i = 1; i < splitStr.length; i++) {
            if (splitStr[i].equals("+")) {
                sum += Integer.parseInt(splitStr[i + 1]);
            } else if (splitStr[i].equals("-")){
                sum -= Integer.parseInt(splitStr[i + 1]);
            } 
        }
        return sum;
    }
}