class Solution {
    public int compress(char[] chars) {
        
        int n = chars.length;
        int i = 0, j = 0, index = 0;
        while(i<n){
            int cnt = 0;
            char currentChar = chars[i];
            while(i<n && chars[i]==currentChar){
                cnt++;
                i++;
            }
            chars[index++] = currentChar;
            if(cnt>1){
                for(char c : String.valueOf(cnt).toCharArray()){
                    chars[index++] = c;
                }
            }
        }
        System.out.println(index);
        return index;
    }
}
