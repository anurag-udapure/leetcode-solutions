class Solution {
    public int bitwiseComplement(int n) {
        String bin = Integer.toBinaryString(n);
        String comp = "";
        for(int i = 0; i < bin.length(); i++){
            if(bin.charAt(i) == '0'){
                comp += "1";
            }
            else{
                comp += "0";
            }
        }
        return Integer.parseInt(comp,2);
    }
}