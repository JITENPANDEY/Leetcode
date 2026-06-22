class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for(int i=0;i<len;i++) {
            if(flowerbed[i]==0){
                boolean isLeftEmpty = (i==0) || flowerbed[i-1] == 0;
                boolean isRightEmpty = (i==len-1) || flowerbed[i+1] == 0;
                if(isLeftEmpty && isRightEmpty){
                    flowerbed[i]=1;
                    n--;
                }
            }
        }
        return n<=0;
    }
}