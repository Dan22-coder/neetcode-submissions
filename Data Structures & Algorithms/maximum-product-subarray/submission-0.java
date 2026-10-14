class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int leftInteger = 1;
        int rightInteger = 1;

        int ans = Integer.MIN_VALUE;

        for(int i = 0; i <= n-1; i++){
            leftInteger = leftInteger == 0 ? 1 : leftInteger;
            rightInteger = rightInteger == 0 ? 1 : rightInteger;

            leftInteger *= nums[i];

            rightInteger *= nums[n - 1 - i];

            ans = Math.max(ans, Math.max(leftInteger, rightInteger));
        }

        return ans;
    }
}