class Solution {
    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < timelogs.length; i++) {
            int standTime = calcStandTime(schedules[i]);
            boolean flag = true;
            int currentDay = startday;
            for (int j = 0; j < timelogs[i].length; j++) {
                // 주말 인 경우는 무조건 통과
                if (currentDay % 7 == 6 || currentDay % 7 == 0) {
                    currentDay++;
                    continue;
                }
                // 시간이 넘어간 경우
                if (timelogs[i][j] > standTime) {
                    flag = false;
                    break;
                }
                currentDay++;
            }
            if (flag) answer++;
        }


        return answer;
    }

    public static int calcStandTime(int tempTime) {
        int time = tempTime / 100;
        int minute = (tempTime % 100) + 10;

        // 60 분을 넘어가는 경우
        if (minute >= 60) {
            minute -= 60;
            time += 1;
        }
        // 24시를 넘어가는 경우
        if (time >= 24) {
            time -= 24;
        }

        return time * 100 + minute;
    }
}