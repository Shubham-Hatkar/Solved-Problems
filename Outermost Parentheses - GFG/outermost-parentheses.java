//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.removeOuter(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    public static String removeOuter(String s) 
    {
       int n = s.length();
       int start = 0;
       int count = 0;
       String ans = "";
       
       for(int i = 0; i < n; i++)
       {
           char curr = s.charAt(i);
           
           if(curr == '(') count++;
           else count--;
           
           if(count == 0)
           {
               ans += s.substring(start+1, i);
               start = i + 1;
           }
       }
       return ans;
    }
}
