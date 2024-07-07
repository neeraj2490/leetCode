class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        IntegerSet obj = new IntegerSet();

        findAllSubset(nums, 0, obj, new ArrayList<Integer>());

        return obj.resultSet;
    }

    private void findAllSubset(int[] nums, int pointer, IntegerSet obj, List<Integer> currentList) {

        List<Integer> temp = new ArrayList<Integer>(currentList);

        obj.resultSet.add(temp);

        for(int i = pointer; i < nums.length; i++) {

            int num = nums[i];

            currentList.add(num);

            findAllSubset(nums, i + 1, obj, currentList);

            currentList.remove(currentList.size() - 1);
        }
    }
}

class IntegerSet {
    List<List<Integer>> resultSet = new ArrayList<>();
}

/***
     findAllSubset(nums, 0, obj, [])

     []
     findAllSubset(nums, 1, obj, [1])

     [1] 
     findAllSubset(nums, 2, obj, [1, 2])

    [1, 2]
    findAllSubset(nums, 2, obj, [1, 2, 3])
     
    [1, 2, 3]

    [1, 2]

    [1, 3]
    
 */
