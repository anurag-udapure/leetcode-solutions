class Solution {
    public int reverseBits(int n) {
        String binary = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');
        String revbinary = new StringBuilder(binary).reverse().toString();
        int m = Integer.parseInt(revbinary,2);
        return m;
    }
}