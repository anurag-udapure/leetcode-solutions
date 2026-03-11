import java.util.*;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {

        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {

            int target = nums.get(i);
            int res = -1;

            for (int x = 0; x < target; x++) {
                if ((x | (x + 1)) == target) {
                    res = x;
                    break;
                }
            }

            ans[i] = res;
        }

        return ans;
    }
}