class Solution {
    public int largestRectangleArea(int[] heights) {
        int nsl[]=new int[heights.length];
        int nsr[]=new int[heights.length];
        //Calculating next smaller right
        Stack<Integer> r =new Stack<>();
        for(int i=heights.length-1;i>=0;i--)
        {
            while(!r.isEmpty()&&heights[i]<=heights[r.peek()])
            {
                r.pop();
            }
            if(r.isEmpty())
            {
                nsr[i]=heights.length;
            }
            else
            {
                nsr[i]=r.peek();
            }
            r.push(i);
        } 
         //Calculating next smaller left
        Stack<Integer> l =new Stack<>();
        for(int j=0;j<heights.length;j++)
        {
            while(!l.isEmpty()&&heights[j]<=heights[l.peek()])
            {
                l.pop();
            }
            if(l.isEmpty())
            {
                nsl[j]=-1;
            }
            else
            {
                nsl[j]=l.peek();
            }
            l.push(j);
        }
        int max=0;
        //calculating area
        for(int i=0;i<heights.length;i++)
        {
            int width=nsr[i]-nsl[i]-1;
            int area=heights[i]*width;
            if(area>max)
                max=area;

        }
        return max;
               
    }
}