class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Combination obj = new Combination();
        findCombination(candidates, target,0, obj, new ArrayList<Integer>());
        return obj.combinations;
    }

    private void findCombination(int[] candidates, int target, int pointer, Combination obj, ArrayList<Integer> tempList) {
        while(pointer < candidates.length) {
            target = target - candidates[pointer];
            if(target > 0) {
                tempList.add(candidates[pointer]);
                findCombination(candidates, target , pointer, obj, tempList);
                tempList.remove(tempList.size() - 1);
            }
            else if(target == 0) {
                tempList.add(candidates[pointer]);
                List<Integer> t = new ArrayList<>(tempList);
                obj.combinations.add(t);
                tempList.remove(tempList.size() - 1);
            }
            else if(target < 0) {

            }
            target = target + candidates[pointer];
            pointer = pointer + 1;
        }
    }

}

class Combination {
    List<List<Integer>> combinations = new ArrayList<>();
    ArrayList<Integer> tempList = new ArrayList<Integer>();
}
