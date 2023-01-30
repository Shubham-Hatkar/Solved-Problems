//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int idx;
    private void CreateBST(int arr[], int ans[], int start, int end)
    {
        if(start > end) return;
        int mid = (start + end) / 2;
        //Node root = new Node(arr[mid]);
        ans[idx++] = arr[mid];
        CreateBST(arr, ans, start, mid - 1);
        CreateBST(arr, ans, mid + 1, end);
    }
    public int[] sortedArrayToBST(int[] nums)
    {
        // Form a BST
        idx = 0;
        int ans[] = new int[nums.length];
        CreateBST(nums, ans, 0, nums.length - 1);
        return ans;
    }
}