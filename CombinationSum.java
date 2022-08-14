import java.util.*;

class CombinationSum {
    // Time Complexity - O(2^(target))
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList();
        
        backtrack(candidates, target, res, curr, 0);
        
        return res;
    }
    
    public void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> curr, int index) {
        if (target == 0) {
            res.add(new ArrayList(curr));
            return;
        }
        if (index >= candidates.length || target < 0) {
            return;
        }
        
        curr.add(candidates[index]);
        backtrack(candidates, target - candidates[index], res, curr, index);
        
        curr.remove(curr.get(curr.size() - 1));
        backtrack(candidates, target, res, curr, index + 1);
    }
}
