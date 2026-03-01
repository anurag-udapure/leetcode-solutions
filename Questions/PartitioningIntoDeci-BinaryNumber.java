class Solution {
    public int minPartitions(String n) {
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n.length(); i++){
            ans = Math.max(ans,(n.charAt(i)-'0'));
        }
        return ans;
    }
}