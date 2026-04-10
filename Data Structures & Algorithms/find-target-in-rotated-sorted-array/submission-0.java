class Solution {
    public int search(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            if(target == nums[i]) return i;
        }
        return -1;
    }
}

/**
Initially I considered a brute-force approach where I iterate through the array,
check every possible value, and find the index of the target.
However it takes O(n) time complexity, it is not the optimal way to find the answer.
*/
