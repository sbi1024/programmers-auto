class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int[] result = new int[num2 - num1 + 1];
        int resultIndex = 0;
        for (int i = num1; i <= num2; i++) {
            result[resultIndex] = numbers[i];
            resultIndex++;
        }
        return result;
    }
}