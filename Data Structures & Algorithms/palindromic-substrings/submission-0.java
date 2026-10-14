class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            //odd

            count += countPalindromes(s, i, i);

            //even

            count += countPalindromes(s, i, i + 1);
        }

        return count;
    }

    public static int countPalindromes(String s, int l, int r){

        int count1 = 0;

        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            count1++;
            l--;
            r++;
        }
        return count1;
    }
}