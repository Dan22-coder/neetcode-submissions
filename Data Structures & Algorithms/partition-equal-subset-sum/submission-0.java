class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        if(sum % 2 != 0){
            return false;
        }else{
            return subSetSum(nums, sum/2);
        }
    }

    public static boolean subSetSum(int[] arr, int sum){
        int n = arr.length;
        boolean[][] t = new boolean[n + 1][sum + 1];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= sum; j++){
                if(i == 0){
                    t[i][j] = false;
                }
                else if(j == 0){
                    t[i][j] = true;
                }
                else if(arr[i - 1] <= j){
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                }else{
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][sum];
    }

}