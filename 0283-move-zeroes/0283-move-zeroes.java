class Solution {
    public void moveZeroes(int[] nums) {

        //# Solution 1

        // int index = 0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]!=0){
        //         nums[index] = nums[i];
        //         index++;
        //     }
        // }
        // while(index<nums.length){
        //     nums[index++] = 0;
        // }

        // #Solution 2
        int j = 0, n = nums.length;
        for(int i=0;i<n;i++) {
            if(nums[i]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}