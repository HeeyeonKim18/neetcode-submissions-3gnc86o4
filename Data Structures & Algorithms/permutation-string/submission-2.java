class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr = new int[26];
        int target = 0;
        for(int i = 0; i < s1.length(); i++){
            int ch = s1.charAt(i) - 'a';
            if(arr[ch] == 0){
                target++;
            }
            arr[ch]++;
        }

        int l = 0;
        int count = 0; 
        for(int r = 0; r < s2.length(); r++){
            int ch = s2.charAt(r) - 'a';
            arr[ch]--;
            if(arr[ch] == 0) count++;

            if(r - l + 1 == s1.length()){
                if(count == target) return true;
                int lChar = s2.charAt(l) - 'a';
                if(arr[lChar] == 0) count--;
                arr[lChar]++;
                l++;
            }
        }
        return false;
    }
}
