class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();
        for(String s : strs){
            char[] keyArray = s.toCharArray();
            Arrays.sort(keyArray);

            String key = String.valueOf(keyArray);
            group.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(group.values());
    }

}