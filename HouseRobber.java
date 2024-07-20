class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        
        int[][] results = new int[len][2];

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < 2; j++) {
                results[i][j] = -1;
            }
        }

        return rob(nums, 0, len, -2, results);
    }

    private int rob(int[] nums, int houseNumber, int numberOfHouse, int previousHouseNumberRobbed, int[][] results) {

        if(houseNumber >= numberOfHouse) {
            return 0;
        }

        else {
            if(houseNumber == previousHouseNumberRobbed + 1) {

                if(results[houseNumber][0] != -1) {
                    return results[houseNumber][0];
                } 
                else  {
                    return rob(nums, houseNumber + 1, numberOfHouse, previousHouseNumberRobbed, results);
                }
            } 

            //previous house was not robbed

            else {

                //I rob the current house
                int a = results[houseNumber][1] != -1 ? results[houseNumber][1] : rob(nums, houseNumber + 1, numberOfHouse, houseNumber, results) + nums[houseNumber];
                results[houseNumber][1] = a;

                //I decide not to rob the current house
                int b = results[houseNumber][0]  != -1 ? results[houseNumber][0] : rob(nums, houseNumber + 1, numberOfHouse, previousHouseNumberRobbed, results);
                results[houseNumber][0] = b;

                return a > b ? a : b;
            }
        }
    }
}
