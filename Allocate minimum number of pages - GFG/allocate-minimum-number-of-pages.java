//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    private static boolean isPossible(int arr[], int maxBound, int students)
    {
        int count = 1;
        int currPages = 0;
        
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] > maxBound) return false;
            
            currPages += arr[i];
            
            if(currPages > maxBound)
            {
                count++;
                currPages = arr[i];
            }
            if(count > students) return false;
        }
        return (count <= students);    
    }
    //Function to find minimum number of pages.
    public static int findPages(int[]arr,int N,int M)
    {
        int minPages = 0;
        int totalPages = 0;
        
        for(int i = 0; i < N; i++)
        {
            minPages = Math.min(minPages,arr[i]);
            totalPages += arr[i];
        }
        
        // If students are > books
        if(M > N) return -1;
        
        int start = minPages;
        int end = totalPages;
        int ans = -1;
        while(start <= end)
        {
            int mid = (start + end) / 2;
            if(isPossible(arr, mid, M))
            {
                ans = mid;
                end = mid - 1;
            }
            else start = mid + 1;
        }
        return ans;
    }
};