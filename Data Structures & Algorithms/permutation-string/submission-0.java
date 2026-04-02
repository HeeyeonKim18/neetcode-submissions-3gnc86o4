class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr = new int[26];

        for(int i = 0; i < s1.length(); i++){
            int ch = s1.charAt(i) - 'a';
            arr[ch]++;
        }

        int l = 0;
        for(int r = 0; r < s2.length(); r++){
            int ch = s2.charAt(r) - 'a';
            arr[ch]--;

            if(r - l + 1 == s1.length()){
                boolean res = Arrays.stream(arr).allMatch(x -> x == 0);
                if(res) return true;
                arr[s2.charAt(l) - 'a']++;
                l++;
            }
        }
        return false;
    }
}
