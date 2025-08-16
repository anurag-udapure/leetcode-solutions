class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        //Operation:
        for(int i = 0; i < n-1; i++){
            if(nums[i] == nums[i+1]){
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }
         //Moving all zeroes to right
         int[] arr = new int[n];
         int j = 0;
         for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                arr[j] = nums[i];
                j++;
            }
        }
        for(int k = j; k < n; k++){
            arr[k] = 0;
        }
    return arr;
    }
}