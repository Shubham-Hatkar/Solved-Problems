//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    sc.nextLine();
		    Solution obj = new Solution();
		    String arr[]=sc.nextLine().split(" ");
		    System.out.println(obj.mostFrequentWord(arr, n));
		    
		}
	}
}

// } Driver Code Ends
//User function Template for Java


class Solution
{
    //Function to find most frequent word in an array of strings.
    public String mostFrequentWord(String arr[],int n)
    {
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            hm.put(arr[i], hm.getOrDefault(arr[i],0) + 1);
        }
        
        int ans = -1;
        int idx = 0;
        for(int i = 0; i < n; i++)
        {
            if(hm.get(arr[i]) >= ans)
            {
                ans = hm.get(arr[i]);
                idx = i;
                hm.put(arr[i],-1);
            }
        }
        return arr[idx];
    }

}


//{ Driver Code Starts.
// } Driver Code Ends