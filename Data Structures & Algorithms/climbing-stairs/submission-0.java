class Solution {
    static int[] t = new int[46];

    public int climbStairs(int n) {
        Arrays.fill(t, -1);
        return solve(n);
    }

    public static int solve(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        if(t[n] != -1){
            return t[n];
        }

        int ways = 0;

        ways += solve(n-1) + solve(n-2);

        return t[n] =  ways;
    }
}