//{ Driver Code Starts
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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    private boolean DFS(int src, char c, char color[], boolean vis[], ArrayList<ArrayList<Integer>>adj)
    {
        vis[src] = true;
        color[src] = c;
        
        for(int nbr : adj.get(src))
        {
            if(vis[nbr] == false)
            {
                char opposite_color = (c == 'R') ? 'G' : 'R';
                if(DFS(nbr, opposite_color, color, vis, adj) == false) return false;
            }
            if(vis[nbr] == true && color[nbr] == c) return false;
        }
        vis[src] = false;
        return true;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        boolean vis[] = new boolean[V];
        char color[] = new char[V];
        for(int i = 0; i < V; i++)
        {
            if(DFS(i, 'R', color, vis, adj) == false) return false;
        }
        return true;
    }
}