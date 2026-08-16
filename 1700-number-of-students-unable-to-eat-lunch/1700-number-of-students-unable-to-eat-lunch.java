import java.util.*;
class Solution {
    public int countStudents(int[] students, int[] sandwiches) 
    {
        Stack<Integer> sand=new Stack<>();
        int i;
        for(i=sandwiches.length-1;i>=0;i--)
        {
            sand.add(sandwiches[i]);
        }
        Queue<Integer> stud=new LinkedList<>();
        for(i=0;i<students.length;i++)
        {
            stud.add(students[i]);
        }
        int c=0;
        while(true)
        {
            while(!sand.isEmpty()&&sand.peek()==stud.peek())
            {
                stud.remove();
                sand.pop();
                c=0;
            }
            
            c++;
            if(c>stud.size())
                break;
            stud.add(stud.remove());
        }
        return stud.size();
    }
}