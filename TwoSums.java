class Solution {
    public int[] twoSum(int[] nums, int target) {

        int num1 = -1; 
        int num2 = -1;
        int result[] = new int[2];

        int lenOfArray = nums.length;
        int temp[] = new int[lenOfArray];
       
        for(int i = 0; i < lenOfArray; i++) {
            temp[i] = nums[i];
        }
 
        Arrays.sort(temp);
 
        for(int i = 0; i < lenOfArray - 1; i++) {

            int currentNum = temp[i]; 
            int toFind = target - currentNum; 

            int index = binarySearch(temp, toFind, i+1, lenOfArray - 1);

            if(index != -1) {
                num1 = currentNum;
                num2 = toFind;
                break;
            }            
        }

        for(int i = 0, j = 0; i < lenOfArray; i++) {
            if(nums[i] == num1) {
                result[j++] = i;
            } else if(nums[i] == num2) {
                result[j++] = i;
            }
        }
        
        return result;
    }

    private int binarySearch(int[] nums, int target, int lower, int upper) {

        if(lower > upper) { 
            return -1;
        }

        int mid = (upper + lower)/2; 

        if(target == nums[mid]) {
            return mid;
        }
        else if(target > nums[mid]) { 
            return binarySearch(nums, target, mid + 1, upper);
        }
        else {
            return binarySearch(nums, target, lower, mid - 1); 
        }
    }
}
