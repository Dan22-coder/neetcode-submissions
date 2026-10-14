class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        HashMap<String, Integer> map = new HashMap<>();

        return dfs(0, 0, s, t, map, n, m);
    }

    public static int dfs(int i, int j, String s, String t, HashMap<String, Integer> map, int n, int m){
        if(j == m){
            return 1;
        }
        if(i == n){
            return 0;
        }

        String key = i + "_" + j;
        if(map.containsKey(key)){
            return map.get(key);
        }

        int res;

        if(s.charAt(i) == t.charAt(j)){
            res = dfs(i + 1, j + 1, s, t, map, n, m) + dfs(i + 1, j, s, t, map, n, m);
        }else{
            res = dfs(i + 1, j, s, t, map, n, m);
        }

       map.put(key, res);

       return res;
    }
}
