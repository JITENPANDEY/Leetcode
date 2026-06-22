class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int left = 0, right = s.length()-1;
        while(left<right) {
            if(isVowel(sb.charAt(left)) && isVowel(sb.charAt(right))){
                char temp = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(right));
                sb.setCharAt(right, temp);

                left++;
                right--;
            }
            if(!isVowel(sb.charAt(left))) left++;
            if(!isVowel(sb.charAt(right))) right--;
            
        }
        return sb.toString();
    }
    private boolean isVowel(char c){
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}