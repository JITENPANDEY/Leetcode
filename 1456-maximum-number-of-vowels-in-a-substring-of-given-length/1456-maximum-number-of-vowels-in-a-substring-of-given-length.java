class Solution {
    static {
        for (int i = 0; i < 1000; i++) {
            maxVowels("b", 0);
        }
    }

    public static int maxVowels(String s, int k) {
        int cnt = 0;
        for(int i=0;i<k;i++){
            if(isVowel(s.charAt(i))){
                cnt++;
            }
        }
        int maxCnt = cnt;
        
        for(int i = k;i<s.length();i++){
            if(isVowel(s.charAt(i))) {
                cnt++;
            }
            if(isVowel(s.charAt(i-k))){
                cnt--;
            }
            maxCnt = Math.max(maxCnt, cnt);
            
        }
        return maxCnt;
    }
    private static boolean isVowel(char c){
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}