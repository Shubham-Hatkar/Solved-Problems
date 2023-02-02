//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{
    public static List<Integer> shortestPath(int n, int m, int edges[][]) 
    {
        // Create a graph
        ArrayList<int[]>[] graph = new ArrayList[n+1];
        for(int i = 0; i <= n; i++)  graph[i] = new ArrayList<>();
        
        for(int[] e : edges)
        {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            graph[u].add(new int[]{v,wt});
            graph[v].add(new int[]{u,wt});
        }
        
        int parent[] = new int[n+1];
        for(int i = 0; i <= n; i++) parent[i] = i;
        int distance[] = new int[n+1];
        for(int i = 0; i <= n; i++) distance[i] = Integer.MAX_VALUE;
        distance[1] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        pq.add(new int[]{1,0});
        
        while(!pq.isEmpty())
        {
            int temp[] = pq.remove();
            int node = temp[0];
            int node_dist = temp[1];
            
            for(int[] e : graph[node])
            {
                int nbr = e[0];
                int wt = e[1];
                
                if(distance[nbr] > distance[node] + wt)
                {
                    distance[nbr] = distance[node] + wt;
                    parent[nbr] = node;
                    pq.add(new int[]{nbr, distance[nbr]});
                }
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(distance[n] == Integer.MAX_VALUE) 
        {
            ans.add(-1);
            return ans;
        }
        
        
        ans.add(n);
        int copy = n;
        while(parent[copy] != copy)
        {
            ans.add(parent[copy]);
            copy = parent[copy]; 
        }
        
        Collections.reverse(ans);
        return ans;
    }
}




