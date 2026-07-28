class Solution {
    public void sum(int[] cand,int t,List<List<Integer>> res,List<Integer> ans,int currSum,int i ){
        if(currSum == t){
            List<Integer> ans1 = new ArrayList<>();
            ans1.addAll(ans);
            Collections.sort(ans1);
            if(!res.contains(ans1))
            {
            res.add(new ArrayList<>(ans1));
            }
            return;
        }
        if(currSum > t || i == cand.length){
           return;
        }
        ans.add(cand[i]);
        sum(cand,t,res,ans,currSum+cand[i],i+1);
        ans.remove(ans.size() -1);
        while (i + 1 < cand.length && cand[i] == cand[i + 1]) {
            i++;
        }

        sum(cand,t,res,ans,currSum,i+1);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int currSum=0,i=0;

        sum(candidates,target,res,ans,currSum,i);
        return res;
    }
}