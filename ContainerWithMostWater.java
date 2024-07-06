class Solution {
    public int maxArea(int[] height) {
        
        int numberOfContainer = height.length;
        int maxCapacity = 0;

        for(int i = 0, j = numberOfContainer-1; i < j; ) {
            int capacity = (j - i) * Math.min(height[i], height[j]);

            if(capacity > maxCapacity) {
                maxCapacity = capacity;
            }

            if(height[i] < height[j]) {
                i++;
            } else {
                j--;
            }             
        }
        return maxCapacity;
    }
}
