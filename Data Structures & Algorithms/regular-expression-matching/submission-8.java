class Solution {
    public boolean isMatch(String s, String p) {


        HashMap<String, Boolean> map = new HashMap<>();

        return dfs(0, 0, s, p, map);
    }

    public static boolean dfs(int i, int j, String s, String p, HashMap<String, Boolean> map){
        if(i >= s.length() && j >= p.length()){
            return true;
        }
        if(j >= p.length()){
            return false;
        }

        String key = i + " " + j;
        if(map.containsKey(key)){
            return map.get(key);
        }

        boolean ans;

        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
            ans = dfs(i, j + 2, s, p, map) || (match && dfs(i + 1, j, s, p, map));
        }else{
             ans = match && dfs(i + 1, j + 1, s, p, map);
        }

        map.put(key, ans);
        return ans;
    }
}
