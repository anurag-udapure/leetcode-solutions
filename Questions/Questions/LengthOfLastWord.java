class Solution {
    public int lengthOfLastWord(String s) {
        int size = s.length();
        int len = 0; 
        boolean flag = false;
        for(int i = size-1; i >= 0; i--){
            if(s.charAt(i) == ' '){
                if(flag == false){
                    continue;
                }
                else{
                    break;
                }
            }
            else{
                len++;
                flag = true;
            }
        }
        return len;
    }
}