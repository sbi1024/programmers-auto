class Solution {
    public int solution(int price) {
        double calPercent = 1;
        if (price >= 500000) {
            calPercent = 0.8;
        }
        else if (price >= 300000) {
            calPercent = 0.9;
        }
        else if (price >= 100000) {
            calPercent = 0.95;
        }
        return (int) (price * calPercent);
    }
}