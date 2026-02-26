class Solution {
    public static void swap1(int[][] matrix,int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
    public static void swap2(int[][] matrix,int i,int k, int j){
        int temp = matrix[i][k];
        matrix[i][k] = matrix[i][j];
        matrix[i][j] = temp;
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //Transpose the Matrix:
        for(int i = 0; i < n-1 ; i++){
            for(int j = i+1; j < n; j++){
                swap1(matrix,i,j);
            }
        }
        // Reverse the rows:
        for(int i = 0; i < n; i++){
            int k  = 0, j = n-1;
            while(k < j){
                swap2(matrix,i,k,j);
                k++;
                j--;
            }
        }
    }
}