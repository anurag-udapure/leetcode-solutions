class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        //Inserting 1st row and 1st column values:
        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i];
        }
        for(int j = 1; j < m; j++){
            dp[j][0] = matrix[j][0];
        }

        int sum = 0;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 1){
                    int min1 = Math.min(dp[i-1][j],dp[i-1][j-1]);
                    dp[i][j] = Math.min(min1,dp[i][j-1]) + 1;
                }
            }
        }
         for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
               sum += dp[i][j];
            }
        }
        return sum;
    }
}