class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // maximum 2 elements will be present
        Integer candidate1 = null, candidate2 = null, count1 = 0, count2 = 0;
        for(int num : nums){
            if(candidate1!=null && num==candidate1){
                count1++;
            } else if (candidate2!=null && num==candidate2){
                count2++;
            } else if(count1==0){
                candidate1 = num;
                count1 = 1;
            } else if(count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0;
        List<Integer> ans = new ArrayList<>();
        for(int val : nums) {
            if(val == candidate1){
                count1++;
            } else if (val == candidate2) {
                count2++;
            }
        }

        if(count1>nums.length/3){
            ans.add(candidate1);
        }
        if(count2>nums.length/3){
            ans.add(candidate2);
        }
        return ans;  
    }
}