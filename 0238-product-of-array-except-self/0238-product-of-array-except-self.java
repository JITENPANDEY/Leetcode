class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n];
        Arrays.fill(arr, 1);
        // update ans array with prefix product
        int left = 1;
        for(int i=0;i<n;i++) {
            arr[i] = arr[i]*left;
            left = left*nums[i];
        }

        // update ans array with prefix product
        int right = 1;
        for(int i=n-1;i>=0;i--) {
            arr[i] = arr[i]*right;
            right = right*nums[i];
        }
        return arr;
    }
}