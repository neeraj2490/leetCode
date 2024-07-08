class Solution {
    public void nextPermutation(int[] nums) {
        
        int len = nums.length;

        // if the nums are in descending order
        boolean isDescending = true;
        for(int i = 0; i < len - 1; i++) {
            if(nums[i] < nums[i+1]) {
                isDescending = false;
                break;
            }
        }

        //reverse the array
        if(isDescending) {
            for(int i = 0, j = len -1 ; i < j; i++, j--) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            return;
        }

        boolean isAscending = true;
        for(int i = 0; i < len - 1; i++) {
            if(nums[i] > nums[i+1]) {
                isAscending = false;
                break;
            }
        }

        if(isAscending) {
            int temp = nums[len-1];
            nums[len-1] = nums[len-2];
            nums[len-2] = temp;
            return;
        }

        int index = -1;
        for(int i = len - 2; i >= 0; i--) {

            if(nums[i] < nums[i+1]) {
                index = i;
                break;
            }
        }

        int max = Integer.MAX_VALUE;
        int index2 = -1;
        for(int i = len - 1; i > index; i--) {

            if(nums[i] > nums[index] && nums[i] < max) {
                index2 = i;
                max = nums[i];
            }
        }

        int temp = nums[index2];
        nums[index2] = nums[index];
        nums[index] = temp;

        Arrays.sort(nums, index+1, len);
        
    }
}
