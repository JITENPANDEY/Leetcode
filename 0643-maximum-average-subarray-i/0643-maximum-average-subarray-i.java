class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int currentSum = 0;

        for (int index = 0; index < k; index++) {
            currentSum += nums[index];
        } 
        int maxSum = currentSum;
        for(int i=k;i<n;i++){
            currentSum = currentSum + nums[i] - nums[i-k];
            maxSum = Math.max(maxSum, currentSum);
        }
        return (double) maxSum/k;
    }
}