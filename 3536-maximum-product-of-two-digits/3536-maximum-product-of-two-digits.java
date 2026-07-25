class Solution {
    public int maxProduct(int n) {
        int max1 = n%10;
        n = n/10;
        int max2 = n%10;
        n = n/10;
        while(n !=0){
            int num  = n%10;
            if(max1>=max2 && num > max2){
                max2 = num;
            } else if(max1 <= max2 && num>max1) {
                max1 = num;
            }
            n /= 10;
        }
        return max1*max2;
    }
}
