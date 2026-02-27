class Solution {
    public int binaryGap(int n) {
        String binary = Integer.toBinaryString(n);
        int m = binary.length();
        int max_distance = Integer.MIN_VALUE;
        boolean flag = false;
        if(Integer.bitCount(n) == 1) return 0;
        for(int i = 0; i < m; i++){
            if(binary.charAt(i) == '1'){
                for(int j = i+1; j < m; j++){
                    if(binary.charAt(j) == '1' && flag == false){
                        max_distance = Math.max(max_distance,j-i);
                        flag = true;
                    }
                }
            }
            flag = false;
        }
        return max_distance;
    }
}