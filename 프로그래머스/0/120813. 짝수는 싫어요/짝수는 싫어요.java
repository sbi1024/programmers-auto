class Solution {
    public int[] solution(int n) {
        int arrLength = (n % 2) == 0 ? n / 2 : n / 2 + 1;
        int[] arr = new int[arrLength];
        int arrIndex = 0;
        for (int i = 1; i <= n; i += 2) {
            arr[arrIndex] = i;
            arrIndex++;
        }
        return arr;
    }
}