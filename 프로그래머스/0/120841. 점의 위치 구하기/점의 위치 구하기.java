class Solution {
    public int solution(int[] dot) {
        int firstValue = Integer.signum(dot[0]);
        int secondValue = Integer.signum(dot[1]);

        if (firstValue == 1 && secondValue == 1) {
            return 1;
        } else if (firstValue == -1 && secondValue == 1) {
            return 2;
        } else if (firstValue == -1 && secondValue == -1) {
            return 3;
        } else {
            return 4;
        }
    }
    
    
}