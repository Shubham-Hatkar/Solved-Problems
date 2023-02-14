//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            pair ans = obj.indexes(a, k);
            if (ans.first == -1 && ans.second == -1)
                System.out.println(-1);
            else
                System.out.println(ans.first+" "+ans.second);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

/*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/

class Solution 
{
    private long FindFirst(long arr[], long x)
    {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        long ans = 0;
        
        while(start <= end)
        {
            int mid = (start + end) / 2;
            if(arr[mid] >= x)
            {
                ans = (long)(mid);
                end  = mid - 1;
            }
            else start = mid + 1;
        }
        return ans;
    }
    private long FindLast(long arr[], long x)
    {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        long ans = 0;
        
        while(start <= end)
        {
            int mid = (start + end) / 2;
            if(arr[mid] <= x)
            {
                ans = (long)mid;
                start = mid + 1;
            }
            else end = mid - 1;
        }
        return ans;
    }
    public pair indexes(long v[], long x)
    {
        long first = FindFirst(v,x);
        long last = FindLast(v,x);
        if(v[(int)first] != x) first = -1;
        if(v[(int)last] != x) last = -1;
        return new pair(first,last);
    }
}


