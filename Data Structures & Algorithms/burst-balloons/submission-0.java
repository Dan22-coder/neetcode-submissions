class Solution {
    public int maxCoins(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            list.add(nums[i]);
        }

        list.add(0, 1);
        list.add(1);

        int m = nums.length;

        int[][] t = new int[m + 2][m + 2];

        for(int[] row: t){
            Arrays.fill(row, -1);
        }

        int n = list.size();

        return solve(1, n - 2, list, t);
    }

    public static int solve(int L, int R, ArrayList<Integer> list, int[][] t){
        if(L > R){
            return 0;
        }
        if(t[L][R] != -1){
            return t[L][R];
        }

        t[L][R] = 0;
        int coins = 0;

        for(int i = L; i <= R; i++){
            coins = list.get(R + 1) * list.get(i) * list.get(L  - 1);
            coins += solve(i + 1, R, list, t) + solve(L, i - 1, list, t);
            t[L][R] = Math.max(t[L][R], coins);
        }

        return t[L][R];
    }
}