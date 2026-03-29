class Solution 
{
    public void fun(int[] candidates,List<List<Integer>> ans,List<Integer> temp,int idx,int target)
    { 
        if(target==0)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<candidates.length;i++)
        {
            if(i>idx&&candidates[i-1]==candidates[i]) continue;
            if(candidates[i]>target) break;
            temp.add(candidates[i]);
            fun(candidates,ans,temp,i+1,target-candidates[i]);
            temp.remove(temp.size()-1);  
        }
        return;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        fun(candidates,ans,temp,0,target);
        return ans; 
    }
//please upvote...
}