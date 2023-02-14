//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findMin(A, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findMax(int arr[])
    {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        
        while(start <= end)
        {
            int mid = (start + end) / 2;
            if(mid + 1 < n && arr[mid] > arr[mid + 1]) return mid;
            else if(arr[start] <= arr[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return n-1;
    }
    int findMin(int arr[], int n)
    {
        return arr[(findMax(arr) == n-1) ? 0 : findMax(arr) + 1];
    }
}
