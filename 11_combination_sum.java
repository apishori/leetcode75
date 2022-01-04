import java.util.*;
/*
Backtrack reducing target value till we reach zero. Keep track of running sum and index of most recent number
*/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> runningSum = new LinkedList<>();
        helper(candidates, res, runningSum, target, 0);
        return res;
    }
    
    private void helper(int[] candidates,
                        List<List<Integer>> res,
                        LinkedList<Integer> runningSum,
                        int remain, 
                        int start) {
        if(remain == 0) {
            res.add(new ArrayList<>(runningSum));
            return;
        }
        
        for(int i = start; i < candidates.length; ++i) {
            if(remain - candidates[i] < 0) continue;
            runningSum.add(candidates[i]);
            helper(candidates, res, runningSum, remain - candidates[i], i);
            runningSum.removeLast();
        }
    }
}
