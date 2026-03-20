class Solution {
    private int helper(int num) {
       
        if(num == 2) return -1;
        
        int original = num;
        int pos = -1;
        
        while((num & 1) == 1) {
            pos++;              
            num = num >> 1;     
        }
        
        int toSubtract = (int)Math.pow(2, pos);
        
        // Return ans with the toggled bit
        return original - toSubtract;
    }
    
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] result = new int[nums.size()];
        
        for(int i = 0; i < nums.size(); i++) {
            result[i] = helper(nums.get(i));
        }
        
        return result;
    }
}