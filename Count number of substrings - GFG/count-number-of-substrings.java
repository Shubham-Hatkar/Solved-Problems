//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    long AtMostK(String s, int k)
    {
        int start = 0;
        int end = 0;
        long ans = 0;
        int unique = 0;
        int n = s.length();
        int freq[] = new int[123];
        
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
            
            ans += (long)(end - start);
        }
        return ans;
    }
    long substrCount (String S, int K) 
    {
        return AtMostK(S,K) - AtMostK(S,K-1);
    }
}