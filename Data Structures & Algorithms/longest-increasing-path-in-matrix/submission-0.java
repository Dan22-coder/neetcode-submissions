class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                dfs(matrix, i, j, -1, map, ROWS, COLS);
            }
        }

        int maxValue = Collections.max(map.values());

        return maxValue;
    }

    public static int dfs(int[][] matrix, int r, int c, int prevVal, HashMap<String, Integer> map, int ROWS, int COLS){
        if(r < 0 || c < 0 || r == ROWS || c == COLS || matrix[r][c] <= prevVal){
            return 0;
        }

        String key = r + "_" + c;
        if(map.containsKey(key)){
            return map.get(key);
        }

        int res = 1;

        res = Math.max(res, 1 + dfs(matrix, r + 1, c, matrix[r][c], map, ROWS, COLS));
        res = Math.max(res, 1 + dfs(matrix, r - 1, c, matrix[r][c], map, ROWS, COLS));
        res = Math.max(res, 1 + dfs(matrix, r, c + 1, matrix[r][c], map, ROWS, COLS));
        res = Math.max(res, 1 + dfs(matrix, r, c - 1, matrix[r][c], map, ROWS, COLS));

        map.put(key, res);

        return res;
    }
}