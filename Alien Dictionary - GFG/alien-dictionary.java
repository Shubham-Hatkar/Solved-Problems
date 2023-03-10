//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        ArrayList<Integer>[] graph = new ArrayList[K];
        for(int i = 0; i < K; i++) 
            graph[i] = new ArrayList<>();
        
        
        // We are taking two strings for comparing
        for(int i = 0; i < N - 1; i++)
        {
            String s = dict[i];
            String t = dict[i+1];
            
            int size = Math.min(s.length(), t.length());
            for(int j = 0; j < size; j++)
            {
                if(s.charAt(j) != t.charAt(j))
                {
                    graph[s.charAt(j) - 'a'].add(t.charAt(j) - 'a'); // Integer Format
                    break;
                }
            }
        }
        
        
        int indegree[] = new int[K];
        for(int i = 0; i < K; i++)
        {
            for(int e : graph[i]) indegree[e]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < K; i++)
        {
            if(indegree[i] == 0) q.add(i);
        }
        
        int ans[] = new int[K];
        int idx = 0;
        while(!q.isEmpty())
        {
            int temp = q.remove();
            ans[idx] = temp;
            idx++;
            
            for(int nbr : graph[temp])
            {
                indegree[nbr]--;
                if(indegree[nbr] == 0) q.add(nbr);
            }
        }
        
        
        String res = "";
        for(int i = 0; i < K; i++)
        {
            res += (char)(ans[i] + 'a');
        }
        return res;
    }
}