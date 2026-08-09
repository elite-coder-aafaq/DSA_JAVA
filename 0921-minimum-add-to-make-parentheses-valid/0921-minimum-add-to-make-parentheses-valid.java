class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> c= new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(c.isEmpty())
                c.push(ch);
            else if(c.peek()=='('&&ch==')')
                c.pop();
            else
                c.push(ch);
        }
        int counter=0;
        while(!c.isEmpty())
        {
            c.pop();
            counter++;
        }
        return counter;
    }
}