class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, h = letters.length-1;
        while(l <= h){
            int mid = (l + h) / 2;
            if(letters[mid] <=  target){
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }
        return letters[l%letters.length];
    }
}