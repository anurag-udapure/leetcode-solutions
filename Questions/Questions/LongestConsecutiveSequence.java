class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        Arrays.sort(nums);
        int counter = 0, last_smaller = Integer.MIN_VALUE;
        int longest = 1;
        for(int i = 0; i < n; i++){
            if(nums[i]-1 == last_smaller){
                counter++;
                last_smaller = nums[i];
            }
            else if(nums[i] != last_smaller){
                counter = 1;
                last_smaller = nums[i];
            }
            longest = Math.max(longest,counter);
        }
        return longest;
    }
}