class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int res[]=new int[nums.length-k+1];
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
        int j=0;
        for(i=k;i<nums.length;i++)
        {
            res[j++] = nums[dq.getFirst()];

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
        res[j] = nums[dq.getFirst()];

        return res;

    }
}