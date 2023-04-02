//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int arr[][], int n)
    {
    	Stack<Integer> st = new Stack<>();
    	for(int i = 0; i < n; i++) st.push(i);
    	
    	while(st.size() > 1)
    	{
    	    int a = st.pop();
    	    int b = st.pop();
    	    if(arr[a][b] == 1) st.push(b);
    	    else if(arr[b][a] == 1) st.push(a);
    	}
    	if(st.isEmpty()) return -1;
    	int possibleCelebrity = st.pop();
    	int cnt1 = 0;
    	for(int i = 0; i < arr.length; i++)
    	{
    	    if(arr[i][possibleCelebrity] == 1) cnt1++;
    	}
    	
    	int cnt0 = 0;
    	for(int i = 0; i < arr[0].length; i++)
    	{
    	    if(arr[possibleCelebrity][i] == 0) cnt0++;
    	}
    	
    	if(cnt0 == arr[0].length && cnt1 == arr.length - 1) return possibleCelebrity;
    	return -1;
    }
}