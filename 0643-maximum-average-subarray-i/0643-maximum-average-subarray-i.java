class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int WindowSum = 0;
        for(int i =0;i<k;i++){
            WindowSum+=nums[i];
        }
        int maxSum = WindowSum;
        for(int i = k;i<nums.length;i++){
            WindowSum = WindowSum - nums[i-k] + nums[i];
            maxSum = Math.max(maxSum,WindowSum);
        }
        return (double) maxSum / k;
    }
}