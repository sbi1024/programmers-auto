class Solution {
    public int solution(String[] babbling) {
         int answer = 0;
        String[] babblingKeyWord = {"aya", "ye", "woo", "ma"};

        for (int i = 0; i < babbling.length; i++) {
            String babblingStr = babbling[i];
            for (int j = 0; j < babblingKeyWord.length; j++) {
                babblingStr = babblingStr.replace(babblingKeyWord[j], " ");
                if (babblingStr.trim().isEmpty()) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}