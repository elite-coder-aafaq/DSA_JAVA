class Solution {
    public boolean isHappy(int n) {
        int copy=n;
        int checker[]=new int[1000];
        int i=0;
        checker[0]=copy;
        while(true)
        {
            int sum=0;
            while(copy>0)
            {
                int dig=copy%10;
                sum+=dig*dig;
                copy=copy/10;
                
            }
            i++;
            copy=sum;
            checker[i]=sum;
            if(sum==1)
            {
                return true;
            }
            for(int j=0;j<i;j++)
                {
                    if(sum==checker[j])
                    {
                        return false;
                    }
                }
        }
    }
}