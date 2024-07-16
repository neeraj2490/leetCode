class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int maxSum = Integer.MIN_VALUE;

        int maxTillHere = 0;
        for(int i = 0; i < len; i++) {

            maxTillHere = maxTillHere > 0 ? maxTillHere + nums[i] : nums[i];

            if(maxTillHere > maxSum) {
                maxSum = maxTillHere;
            }

            else if(maxTillHere < 0) {
                maxTillHere = 0;
            }
        }

        return maxSum == Integer.MIN_VALUE ? 0 : maxSum;
    }
}
