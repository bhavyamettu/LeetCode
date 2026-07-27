import java.util.*;

class Solution {

    public void sum(int[] cand, int target, int i,
                    List<Integer> ans,
                    List<List<Integer>> res,
                    int currSum) {

        if (currSum == target) {
            res.add(new ArrayList<>(ans));
            return;
        }

        if (currSum > target || i == cand.length) {
            return;
        }

        ans.add(cand[i]);
        sum(cand, target, i, ans, res, currSum + cand[i]);
        ans.remove(ans.size() - 1);

        sum(cand, target, i + 1, ans, res, currSum);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        sum(candidates, target, 0, ans, res, 0);

        return res;
    }
}