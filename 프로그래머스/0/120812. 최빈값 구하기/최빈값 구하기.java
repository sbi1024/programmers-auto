class Solution {
    public int solution(int[] array) {
        // 각 배열에 카운팅한 값을 할당
        int[] result = new int[1000];
        for (int i = 0; i < array.length; i++) {
            result[array[i]]++;
        }

        // 최빈값을 확인
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] > max) {
                max = result[i];
                maxIndex = i;
            }
        }

        // 최빈값의 갯수를 확인
        int count = 0;
        for (int value : result) {
            if (value == max) {
                count++;
            }
        }

        // max 값이 여러개인경우 -1 return
        if (count >= 2) {
            return -1;
        } else { //  아닌 경우 max 값 return
            return maxIndex;
        }
    }
}