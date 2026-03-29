class Solution {
    public List<Integer> grayCode(int n) 
    {
        List<Integer> ans=new ArrayList<>();
        int lim=1<<n;// to find how many numbers are required
        for(int i=0;i<lim;i++)
        {
            ans.add(i^(i>>1));
        }  
        return ans;
    }
}