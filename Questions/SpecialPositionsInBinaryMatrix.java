class Solution {
    public static boolean checkZeroes(int[][] mat,int i, int j,int m, int n){
        //Rows Zero Check 
        int sum1 = 1;
        for(int k = 0; k < n; k++){
           if(k == j)continue;
           sum1 += mat[i][k];
        }
        //Column Zeroes Check:
        int sum2 = 1;
        for(int k = 0; k < m; k++){
           if(k == i)continue;
           sum2 += mat[k][j];
        }
        return (sum1 == 1) && (sum2 == 1)? true:false;  
    }
    public int numSpecial(int[][] mat) {
        int position = 0;
        int n = mat[0].length;
        int m = mat.length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1 && checkZeroes(mat,i,j,m,n)){
                    position++;
                }
            }
        }
        return position;
    }
}