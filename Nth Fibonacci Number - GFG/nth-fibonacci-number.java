//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution 
{
    static long m = 1000000007;
    static long fibo(long n, long dp[])
    {
        if(n <= 1) return n;
        if(dp[(int)n] != -1) return dp[(int)n];
        dp[(int)n] = fibo((n % m) - 1, dp) % m + fibo((n % m) - 2, dp) % m;
        return dp[(int)n] % m;
    }
    static long nthFibonacci(long n)
    {
        // code here
        long dp[] = new long[(int)n+1];
        Arrays.fill(dp, -1);
        return fibo(n, dp);
    }
}