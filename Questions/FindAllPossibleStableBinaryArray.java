class Solution {

    int MOD = 1000000007;
    int[][][][] dp;

    public int numberOfStableArrays(int zero, int one, int limit) {

        dp = new int[zero + 1][one + 1][2][limit + 1];

        // initialize with -1
        for(int i = 0; i <= zero; i++){
            for(int j = 0; j <= one; j++){
                for(int k = 0; k < 2; k++){
                    for(int s = 0; s <= limit; s++){
                        dp[i][j][k][s] = -1;
                    }
                }
            }
        }

        int ans = 0;

        if(zero > 0)
            ans = (ans + helper(zero - 1, one, 0, 1, limit)) % MOD;

        if(one > 0)
            ans = (ans + helper(zero, one - 1, 1, 1, limit)) % MOD;

        return ans;
    }

    public int helper(int zeroes, int ones, int lastbit, int streak, int limit){

        if(streak > limit) return 0;

        if(zeroes == 0 && ones == 0) return 1;

        if(dp[zeroes][ones][lastbit][streak] != -1)
            return dp[zeroes][ones][lastbit][streak];

        int ways = 0;

        if(lastbit == 0){

            if(zeroes > 0){
                ways = (ways + helper(zeroes - 1, ones, 0, streak + 1, limit)) % MOD;
            }

            if(ones > 0){
                ways = (ways + helper(zeroes, ones - 1, 1, 1, limit)) % MOD;
            }

        } else {

            if(zeroes > 0){
                ways = (ways + helper(zeroes - 1, ones, 0, 1, limit)) % MOD;
            }

            if(ones > 0){
                ways = (ways + helper(zeroes, ones - 1, 1, streak + 1, limit)) % MOD;
            }
        }

        return dp[zeroes][ones][lastbit][streak] = ways;
    }
}