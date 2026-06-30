class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // #1. With Sorting O(N*KLogK)
        // Map<String, List<String>> group = new HashMap<>();
        // for(String s : strs){
        //     char[] keyArray = s.toCharArray();
        //     Arrays.sort(keyArray);

        //     String key = String.valueOf(keyArray);
        //     group.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        // }
        // return new ArrayList<>(group.values());

        // #2. Without Sorting O(N*K)
        Map<String, List<String>> group = new HashMap<>();
        for(String s : strs) {
            int[] count = new int[26];
            for(char c : s.toCharArray()){
                count[c - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for(int cnt : count){
                key.append('#').append(cnt);
            }
            group.computeIfAbsent(key.toString(), k-> new ArrayList<String>()).add(s);
        }
        
        return new ArrayList<>(group.values());
    }

}