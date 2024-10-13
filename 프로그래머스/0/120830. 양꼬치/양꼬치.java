class Solution {
    public int solution(int n, int k) {
        int discount = 0;
        int mod = n / 10;
        if (mod > 0) {
            discount = mod * 2000;
        }
        return  (n * 12000) + (k * 2000) - discount;
    }
}