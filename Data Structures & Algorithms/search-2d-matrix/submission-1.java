class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = matrix.length - 1; i >= 0 ; i--){
            if(target == matrix[i][0]) return true;
            else if(target > matrix[i][0]){
                return binary(matrix[i], target);
            }else {
                continue;
            }
        }
        return false;
    }

    private boolean binary(int[] arr, int target){
        int l = 0, r = arr.length - 1;
        while(l <= r){
            int m = l + (r - l) / 2;
            if(arr[m] == target) return true;
            else if(arr[m] < target) l = m + 1;
            else r = m - 1;
        }
        return false;
    }
}
