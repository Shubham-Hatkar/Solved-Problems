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
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

 class Solution
 {
    static boolean isPossible(int arr[], long maxUnit, int worker)
    {
        long currUnits = 0;
        long currWorkers = 1;
        
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] > maxUnit) return false;
            currUnits += arr[i];
            if(currUnits > maxUnit)
            {
                currUnits = arr[i];
                currWorkers++;
            }
        }
        return (currWorkers <= worker);
    }
    static long minTime(int[] arr,int n,int k)
    {
        //code here
        long max = 0;
        long total = 0;
        for(int num : arr)
        {
            max = Math.max(max, num);
            total += num;
        }
        
        long start = max;
        long end = total;
        long ans = -1;
        while(start <= end)
        {
            long mid = (start + end) / 2;
            if(isPossible(arr, mid, k))
            {
                ans = mid;
                end = mid - 1;
            }
            else start = mid + 1;
        }
        return ans;
    }
}


