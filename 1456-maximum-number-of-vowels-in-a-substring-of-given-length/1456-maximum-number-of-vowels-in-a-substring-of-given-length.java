class Solution {
    // 1. Move the lookup array outside to avoid constant heap allocation
    private static final boolean[] isVowel = new boolean[128];
    
    // 2. Initialize it ONCE when the class loads
    static {
        isVowel['a'] = true;
        isVowel['e'] = true;
        isVowel['i'] = true;
        isVowel['o'] = true;
        isVowel['u'] = true;
    }

    public int maxVowels(String s, int k) {
        // 3. Avoid toCharArray() as it copies the entire string into a new memory array
        int len = s.length();
        int count = 0;
        
        // Count vowels in the first window
        for (int i = 0; i < k; i++) {
            if (isVowel[s.charAt(i)]) count++;
        }
        
        int maxCount = count;
        
        // Sliding window
        for (int i = k; i < len; i++) {
            if (isVowel[s.charAt(i)]) count++;     // Add incoming character
            if (isVowel[s.charAt(i - k)]) count--; // Remove outgoing character
            
            if (count > maxCount) {
                maxCount = count;
            }
        }
        
        return maxCount;
    }
}
