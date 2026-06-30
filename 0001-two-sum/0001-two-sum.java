class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> lookup = new HashMap<>();
        for(int i= 0 ;i<n;i++){
            int elementToSearch = target-nums[i];
            if(lookup.containsKey(elementToSearch)) {
                return new int[]{i, lookup.get(elementToSearch)};
            }
            lookup.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}