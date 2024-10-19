class Solution {
    public int solution(int[] numbers) {
        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < numbers.length; i++){
            for (int j = 0; j < numbers.length; j++) {
                if (i != j) {
                    int value = numbers[i] * numbers[j];
                    if (max < value) {
                        max = value;
                    }
                }
            }
        }
        return max;
    }
}