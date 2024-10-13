class Solution {
    public int solution(int n, int k) {
        int mod = n / 10 ;
        return (n * 12000) + (k * 2000) - (mod * 2000);
    }
}