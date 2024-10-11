class Solution {
    public int solution(int n) {
        int pizzaCount = 1;
        while ((pizzaCount * 6) % n != 0) {
            pizzaCount++;
        }
        return pizzaCount;
    }
}