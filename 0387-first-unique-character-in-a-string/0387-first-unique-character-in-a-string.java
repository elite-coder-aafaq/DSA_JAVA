import java.util.*;
class Solution {
    public int firstUniqChar(String s) {
        Queue<Character> q =new LinkedList<>();
        int freq[]= new int[26];
        char ch;
        for(int i=0;i<s.length();i++)
        {
            ch=s.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            while(!q.isEmpty()&&freq[q.peek()-'a']>1)
            {
                q.remove();
            }
        }
        if(q.isEmpty())
        {
            return -1;
        }
        else
        {
            
            for(int i=0;i<s.length();i++)
            {
                if(q.peek()==s.charAt(i))
                    return i;
                
            }
            return -1;
        }
    }
}