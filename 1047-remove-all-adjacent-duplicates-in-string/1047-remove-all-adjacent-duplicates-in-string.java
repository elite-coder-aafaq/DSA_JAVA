import java.util.*;
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> c=new Stack<>();
        StringBuilder ans = new StringBuilder();
        
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(!c.isEmpty()&&ch==c.peek())
            {
                c.pop();
                continue;
            }
            else
            {
                c.push(ch);
            }
        }
        //building the string
        while(!c.isEmpty())
        {
            ans.append(c.pop());
        }
        String reversed = new StringBuilder(ans).reverse().toString(); 
        return reversed;  
    }
}