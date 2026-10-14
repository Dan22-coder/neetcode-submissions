class Solution {
    public String longestPalindrome(String s) {
        String res = "";

        for(int i = 0; i <= s.length()-1; i++){
            //odd
            int l = i;
            int r = i;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
               if(r - l + 1 > res.length()){
                res = s.substring(l, r+1);
               }
               l--;
               r++;
            }

            //even

            l = i;
            r = i+1;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r - l + 1 > res.length()){
                    res = s.substring(l, r+1);
                }

                l--;
                r++;
            }

        }

        if(res.length() == 0){
            res = s.substring(0, 1);
        }

        return res;
    }
}