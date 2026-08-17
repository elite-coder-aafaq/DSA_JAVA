class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int res[]=new int[nums.length-k+1];
        Queue<Integer> ans=new LinkedList<>();
        //first Window
        int i;
        Deque<Integer> dq=new LinkedList<>();
        for(i=0;i<k;i++)
        {
            while(!dq.isEmpty()&&nums[dq.getLast()]<=nums[i])
            {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        //remaining windows
        for(i=k;i<nums.length;i++)
        {
            ans.add(nums[dq.getFirst()]);
            while(!dq.isEmpty() && dq.getFirst()<=i-k)
            {
                dq.removeFirst();
            }
            while(!dq.isEmpty() && nums[dq.getLast()]<=nums[i])
            {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        ans.add(nums[dq.getFirst()]);
        for(i=0;i<res.length;i++)
        {
            res[i]=ans.remove();
        }
        return res;

    }
}