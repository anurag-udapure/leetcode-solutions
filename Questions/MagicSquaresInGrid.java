class Solution {
    public static boolean isMagicSquare(int[][] grid, int r, int c){
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int num = grid[r+i][c+j];
                if(num < 1 || num > 9 || set.contains(num)){
                    return false;
                }
                else{
                    set.add(num);
                }
            }
        }
        int Rsum = grid[r][c] + grid[r][c+1] + grid[r][c+2];
        //Checking Row Sum:
        for(int i = 0; i < 3; i++){
            int gridSum = grid[r+i][c] + grid[r+i][c+1] + grid[r+i][c+2];
            if(gridSum != Rsum){
                return false;
            }
        }
        //Checking Column Sum:
        for(int i = 0; i < 3; i++){
            int gridSum = grid[r][c+i] + grid[r+1][c+i] + grid[r+2][c+i];
            if(gridSum != Rsum){
                return false;
            }
        }
        //Checking Diagonal Sum:
        int dsum = grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2];
        if(dsum != Rsum) return false;

        //Checking Anti-Diagonal Sum:
        int adsum = grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c];
        if(adsum != Rsum) return false;

        return true;
    }
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for(int i = 0; i <= rows-3; i++){
            for(int j = 0; j <= cols-3; j++){
                if(isMagicSquare(grid,i,j)){
                    count++;
                }
            }
        }
        return count;
    }
}