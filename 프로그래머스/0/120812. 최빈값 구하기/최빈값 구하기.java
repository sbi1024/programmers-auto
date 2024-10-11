class Solution {
    public int solution(int[] array) {
        // 각 배열에 카운팅한 값을 할당
        int[] result = new int[1000];
        for (int i = 0; i < array.length; i++) {
            result[array[i]]++;
        }

        // 최빈값 및 중복되는 값인지 확인
        int max = 0;
        int maxIndex = 0;
        boolean multiple = false;
        for (int i = 0; i < result.length; i++) {
            if (result[i] > max) {
                max = result[i];
                maxIndex = i;
                multiple = false;
            } else if (result[i] == max) {
                multiple = true;
            }
        }
        
        // 중복되는 값이라면 -1 return, 아니라면 maxIndex return
        return multiple ? -1 : maxIndex;
    }
}