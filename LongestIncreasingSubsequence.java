class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int len = nums.length;
        int[] result = new int[len];
        for(int i = 0; i < len; i++) {
            result[i] = -1;
        }

        int max = 0;

        for(int i = 0; i < len; i++) {
            int res = lengthOfList(nums, i, len - 1, result);

            if(res > max) {
                max = res;
            }
        }
        return max;

    }

    private int lengthOfList(int[] nums, int start, int end, int [] result) {
        
        if(start == end) {
            result[start] = 1;
            return 1;
        }

        else if(start > end) {
            return 0;
        }

        else if(result[start] != -1) {
            return result[start];
        }
        
        int maxLen = 1;
        
        for(int i = start + 1; i <= end; i++) {
            if(nums[i] > nums[start]) {
                int len = lengthOfList(nums, i, end, result) + 1; 
                if(len > maxLen) {
                    maxLen = len;
                }
            }
        }

        result[start] = maxLen;

        return maxLen;
    }
}

/**
   [10,9,2,5,3,7,101,18]
   lengthOfList(int[] nums, 0, 7, int [] result) 
   lengthOfList(int[] nums, 6, 7, int [] result) 
   

 */
