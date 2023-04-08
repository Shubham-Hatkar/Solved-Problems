//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.canPair(nums, k);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean canPair(int[] arr, int k) {
        int count = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = arr.length;

        for(int i = 0; i < n; i++)
        {
            int rem = arr[i] % k;
            if(rem < 0) rem += k;
            boolean flag = false;
            if(rem == 0)
            {
                if(hm.containsKey(rem) && hm.get(rem) > 0)
                {
                    flag = true;
                    count++;
                    hm.put(rem, hm.getOrDefault(rem, 0) - 1);
                }
            }
            else 
            {
                if(hm.containsKey(k - rem) && hm.get(k - rem) > 0)
                {
                    flag = true;
                    count++;
                    hm.put(k-rem, hm.getOrDefault(k - rem, 0) - 1);
                }
            }
            if(flag == false) hm.put(rem, hm.getOrDefault(rem, 0) + 1);
        }
        return (count == n / 2);
    }
}