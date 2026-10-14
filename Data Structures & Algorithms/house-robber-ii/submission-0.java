class Solution {
    public int rob(int[] nums) {

        int n = nums.length;

    if (n == 1)
    {
        return nums[0];
    }

        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));
    }

    public static int helper(int[] nums, int st, int end){
        int len = end - st + 1;

         if (len == 1)
        {
            return nums[st];
        }
        if(len == 2){
            return Math.max(nums[st], nums[st+1]);
        }

        int[] dp = new int[len];

        dp[0] = nums[st];
        dp[1] = Math.max(nums[st], nums[st+1]);

        for(int i = st + 2, j = 2; i <= end; i++, j++){
            dp[j] = Math.max(dp[j - 2] + nums[i], dp[j - 1]);
        }
        return dp[len - 1];
    }
}