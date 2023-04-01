//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    private int solve(int idx, int arr[], int dp[])
    {
        if(idx >= arr.length) return 0;
        if(idx == arr.length - 1) return arr[arr.length-1];
        if(dp[idx] != -1) return dp[idx];
        
        int pick = arr[idx] + solve(idx + 2, arr, dp);
        int notpick = 0 + solve(idx + 1, arr, dp);
        
        dp[idx] = Math.max(pick, notpick);
        
        return dp[idx];
    }
    public int FindMaxSum(int arr[], int n)
    {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(0, arr, dp);
    }
}