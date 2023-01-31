//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{
    public int longestkSubstr(String s, int k) 
    {
        int n = s.length();
        int freq[] = new int[123];
        int start = 0;
        int end = 0;
        int unique = 0;
        int len = -1;
        
        while(end < n)
        {
            freq[s.charAt(end)]++;
            if(freq[s.charAt(end)] == 1) unique++;
            end++;
            
            while(start < end && unique > k)
            {
                freq[s.charAt(start)]--;
                if(freq[s.charAt(start)] == 0) unique--;
                start++;
            }
            if(unique == k) len = Math.max(len, end-start);
        }
        return len;
    }
}