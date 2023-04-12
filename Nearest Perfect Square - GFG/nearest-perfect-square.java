//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            int ans[] = ob.nearestPerfectSquare(N);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{
    int[] nearestPerfectSquare(int N) 
    {
        int ans[] = new int[2];
        
        int num = (int) Math.sqrt(N);
        if(num * num == N) return new int[]{N, 0};
        
        int lessThanN = num * num;
        int greaterThanN = (num+1) * (num+1);
        
        if(Math.abs(lessThanN - N) < Math.abs(greaterThanN - N)) 
        return new int[]{lessThanN, Math.abs(lessThanN - N)};
        return new int[]{greaterThanN, Math.abs(greaterThanN - N)};
    }
}