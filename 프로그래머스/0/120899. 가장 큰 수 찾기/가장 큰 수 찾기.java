class Solution {
    public int[] solution(int[] array) {
        int maxIndex = - 1;
        int maxValue = Integer.MIN_VALUE;
        
        for (int i = 0 ; i < array.length; i ++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
                maxIndex = i;
            }
        }
        
        return new int[] {maxValue, maxIndex};
    }
}