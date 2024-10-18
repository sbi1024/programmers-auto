class Solution {
    public int solution(String s) {
        String[] split = s.split(" ");
        int sum = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("Z")) {
                sum -= Integer.parseInt(split[i - 1]);
            } else {
                sum += Integer.parseInt(split[i]);
            }
        }
        return sum;
    }
}