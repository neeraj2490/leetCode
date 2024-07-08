class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList();
        
        createPermutations(nums, 0, nums.length - 1, results);

        return results;
    }

    private void createPermutations(int[] nums, int start, int end, List<List<Integer>> results) {
        
        if(start == end) {
            List<Integer> temp = new ArrayList();
            for(int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
            }

            results.add(temp);
            return;
        }

        for(int i = start; i <= end; i++) {
            nums = swap(nums, start, i);
            createPermutations(nums, start + 1, end, results);
            nums = swap(nums, start, i);
        }
    }

    private int[] swap(int[] nums, int posA, int posB) {
        int temp = nums[posA];
        nums[posA] = nums[posB];
        nums[posB] = temp;
        return nums;
    }
}
