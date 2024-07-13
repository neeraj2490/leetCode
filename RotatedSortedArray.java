class Solution {
    public int search(int[] nums, int target) {

        int len = nums.length;

        return search(nums, target, 0, len - 1);
        
    }

    private int search(int[] nums, int target, int start, int end) {
        if(start == end && nums[start] == target) {
            return start;
        }

        else if(start >= end) {
            return  -1;
        }

        else {
            int mid =  ( end + start ) / 2;

            if(target == nums[mid]) {
                return mid;
            } 

            //check if array is rotated
            boolean isArrayRoated = nums[start] > nums[end];

            if(!isArrayRoated) {
                return nums[mid] > target ? search(nums, target, start, mid -1) : search(nums, target, mid + 1, end);
            }

           
            if(nums[mid]  < nums[start]) {
                if(nums[mid] < target && nums[end] >= target) {
                    return  search(nums, target, mid + 1, end);
                }
                return search(nums, target, start, mid -1);

            } else { 
                if(nums[start] <= target && nums[mid] > target) { 
                    return search(nums, target, start, mid -1);
                }
                return  search(nums, target, mid + 1, end);
            }
        }    
    }
}
