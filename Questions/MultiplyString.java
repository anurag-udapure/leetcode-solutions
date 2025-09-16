class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals(0) || num2.equals(0)) return "0";
        int n1 = num1.length();
        int n2 = num2.length();
        int[] result = new int[n1+n2];
        for(int i = n1-1; i >= 0; i--){
            for(int j = n2-1; j >= 0; j--){
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                int mul = d1 * d2;

                int poslow = i+j+1;
                int poshigh = i+j;

                int sum = mul + result[poslow];

                result[poslow] = sum % 10;
                result[poshigh] += sum / 10; 
            }
        }
        StringBuilder product = new StringBuilder();
        for(int num : result){
            if(!(num == 0 && product.length() == 0)){
                product.append(num);
            }
        }
        return product.length() == 0 ? "0" : product.toString();
    }
}