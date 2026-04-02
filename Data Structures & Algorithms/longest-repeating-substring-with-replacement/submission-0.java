class Solution {
    public int characterReplacement(String s, int k) {
        int[] alpha = new int[26];
        int maxCount = 0;
        int res = 0;
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            int idx =s.charAt(r) - 'A';
            alpha[idx]++;
            maxCount = Math.max(maxCount, alpha[idx]);
            if((r - l + 1)- maxCount > k){
                alpha[s.charAt(l)- 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
