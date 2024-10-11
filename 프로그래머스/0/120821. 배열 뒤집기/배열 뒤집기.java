class Solution {
    public int[] solution(int[] num_list) {
        int length = num_list.length;
        int[] resultArr = new int[length];
        int arrIndex = 0;
        for (int i = length - 1; i >= 0; i--) {
            resultArr[arrIndex] = num_list[i];
            arrIndex++;
        }
        return resultArr;
    }
}