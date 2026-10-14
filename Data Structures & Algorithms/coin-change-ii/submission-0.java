class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] t = new int[n + 1][amount + 1];

        return solve(coins, amount, n, t);
    }

    public static int solve(int[] coins, int amount, int n, int[][] t){
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= amount; j++){

                if(i == 0){
                    t[i][j] = 0;
                }
                else if(j == 0){
                    t[i][j] = 1;
                }

                else if(coins[i - 1] <= j){
                    t[i][j] = t[i][j - coins[i - 1]] + t[i - 1][j];
                }else{
                    t[i][j] = t[i - 1][j];
                }
                
            }
        }

        return t[n][amount];
    }
}