//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String s)
    {
        int n = s.length();
        int start = 0;
        int end = 0;
        int freq[] = new int[123];
        int len = Integer.MIN_VALUE;
        
        while(end < n)
        {
            freq[s.charAt(end)]++;
            
            while(start < end && freq[s.charAt(end)] > 1)
            {
                freq[s.charAt(start)]--;
                start++;
            }
            end++;
            len = Math.max(len, end - start);
        }
        return len;
    }
}