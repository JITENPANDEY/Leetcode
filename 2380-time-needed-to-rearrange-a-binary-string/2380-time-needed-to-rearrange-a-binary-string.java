class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int zero = 0;
        int time = 0;
        for(char c : s.toCharArray()) {
            if(c == '0') {
                zero++;
            } else if(zero > 0) {
                time = Math.max(time+1, zero);
            }
        }
        return time;
    }
}