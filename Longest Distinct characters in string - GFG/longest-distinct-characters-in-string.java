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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String s)
    {
        // code here
        int n = s.length();
        int start = 0;
        int end = 0;
        int freq[] = new int[26];
        int ans = 0;
        
        while(end < n)
        {
            freq[s.charAt(end) - 'a']++;
            end ++;
            
            while(start < end && freq[s.charAt(end-1) - 'a'] > 1)
            {
                freq[s.charAt(start) - 'a']--;
                start++;
            }
            ans = Math.max(ans, end - start);
        }
        return ans;
    }
}