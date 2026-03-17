class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 1; i < m; i++){
            for(int j  = 0; j < n; j++){
                if(matrix[i][j] == 1){
                    matrix[i][j] += matrix[i-1][j]; 
                }
            }
        }
        int maxArea = 0;
        for(int i = m-1; i >= 0; i--){
            Arrays.sort(matrix[i]);
            for(int j = n-1; j >= 0; j--){
                int height = matrix[i][j];
                int weight = n-j;
                maxArea = Math.max(maxArea, height * weight);
            }
           
        }
        return maxArea;
    }
}