class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> c=new Stack<>();
        boolean rem[]=new boolean[s.length()];
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
                c.push(i);
            else if(ch==')')
            {
                if(!c.isEmpty())
                    c.pop();
                else
                    rem[i]=true;
            }

        }
        // Remaining '(' are unmatched
        while(!c.isEmpty()) {
            rem[c.pop()] = true;
        }

        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(rem[i])
                continue;
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}