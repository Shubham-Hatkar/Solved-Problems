//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
	static int spanningTree(int V, int E, int edges[][])
	{
	    ArrayList<int[]>[] graph = new ArrayList[V];
	    for(int i = 0; i < V; i++) graph[i] = new ArrayList<>();
	    
	    for(int e[] : edges)
	    {
	        int u = e[0];
	        int v = e[1];
	        int wt = e[2];
	        graph[u].add(new int[]{v,wt});
	        graph[v].add(new int[]{u,wt});
	    }
	    
	    boolean vis[] = new boolean[V];
	    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
	    pq.add(new int[]{0,0,-1});
	    
	    int sum = 0;
	    while(!pq.isEmpty())
	    {
	        int temp[] = pq.remove();
	        int wt = temp[0];
	        int node = temp[1];
	        
	        if(vis[node] == true) continue;
	        
	        vis[node] = true;
	        sum = sum + wt;
	        for(int[] nbr : graph[node])
	        {
	            int nbrnode = nbr[0];
	            int nbrwt = nbr[1];
	            if(vis[nbrnode] == false)
	            {
	                pq.add(new int[]{nbrwt,nbrnode,node});
	            }
	        }
	    }
	    return sum;
	}
}