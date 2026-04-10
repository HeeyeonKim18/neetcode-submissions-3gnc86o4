class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while(l <= r){
            int m = l + (r - l) / 2;

            if(nums[m] == target){
                return m;
            }

            if(nums[m] > nums[r]){
                if(target >= nums[l] && target < nums[m]){
                    r = m - 1;
                }else{
                    l = m + 1;
                }
            }else{
                if(target > nums[m] && target <= nums[r]){
                    l = m + 1;
                }else{
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}
/*
To improve this, I used a binary search approach.
Even though the array is rotated, at least one half of the array is always sorted.

In each iteration, I calculate the middle index.
If nums[m] equals the target, I return the index.
Otherwise, I determine which half is sorted and check whether the target lies within that sorted range.

Based on that, I move the left or right pointier to narrow down the search space.
If the target is not found, I return -1.

This approach reduces the time complexity to O(log n), making it more efficient.
*/

