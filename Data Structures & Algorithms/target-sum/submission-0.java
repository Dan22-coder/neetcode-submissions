class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int len = 0;

        for(int i = 0; i < nums.length; i++){
            len += nums[i];
        }

        if(Math.abs(target) > len || (target + len) % 2 != 0){
            return 0;
        }

        int sum = (target + len)/2;

        return CountOfSubSetSum(nums, sum);
    }

    public static int CountOfSubSetSum(int[] nums, int sum){
        int n = nums.length;
        int[][] t = new int[n + 1][sum + 1];

        t[0][0] = 1;

        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= sum; j++){
                if(nums[i - 1] <= j){
                    t[i][j] = t[i - 1][j - nums[i - 1]] + t[i - 1][j];
                }else{
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][sum];
    }
}