class Solution {
    public String multiply(String num1, String num2) {
        if(num1.charAt(0)=='0' || num2.charAt(0)=='0') {
            return "0";
        }

        int n = num1.length(), m = num2.length();
        int[] product = new int[n+m];
        for(int i = n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                product[i+j+1] += (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                product[i+j] += product[i+j+1]/10;
                product[i+j+1] = product[i+j+1]%10;
            }
        }
        int i = 0;
        while(product[i]==0) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while(i<product.length) {
            sb.append(product[i++]);
        }
        return sb.toString();
    }
}
