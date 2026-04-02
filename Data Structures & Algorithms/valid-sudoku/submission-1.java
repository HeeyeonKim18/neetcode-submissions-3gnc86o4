class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rows= new HashMap<>();
        Map<Integer, Set<Integer>> cols= new HashMap<>();
        Map<Integer, Set<Integer>> boxes= new HashMap<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;

                int num = board[i][j] - '0';
                int boxIdx = (i/3) * 3 + (j/3);

                if(!rows.computeIfAbsent(i, k -> new HashSet<>()).add(num) ||
                !cols.computeIfAbsent(j, k -> new HashSet<>()).add(num) ||
                !boxes.computeIfAbsent(boxIdx, k -> new HashSet<>()).add(num)
                )

                return false;
            }
        }
        return true;
    }
}
