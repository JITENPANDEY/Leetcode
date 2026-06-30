class Solution {
    public int majorityElement(int[] nums) {
        // Boyer-Moore Voting Algorithm
        int candidate = nums[0], count = 1;
        for(int i = 1;i<nums.length;i++){
            if(count==0){
                candidate = nums[i];
                count = 1;
            }
            else if(candidate == nums[i]) {
                count++;
            }
            else {
                count--;
            }
            
        }
        return candidate;
    }
}