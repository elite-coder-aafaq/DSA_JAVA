class Solution {
    //By Aafaq Hussain
    public void sortColors(int[] nums) {
        int z=0,o=0,t=0, i;
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            z++;
            else if(nums[i]==1)
            o++;
            else
            t++;
        }
        for( i=0;i<z;i++)
        {
            nums[i]=0;
        }
        for( i=z;i<z+o;i++)
        {
            nums[i]=1;
        }
        for(i=z+o;i<z+o+t;i++)
        {
            nums[i]=2;
        }
    }
}