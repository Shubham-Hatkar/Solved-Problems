//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Disjoint
{
    int parent[];
    int size[];
    
    Disjoint (int v)
    {
        parent = new int[v+1];
        size = new int[v+1];
        for(int i = 0; i <= v; i++)
        {
            parent[i] = i;
            size[v] = 1;
        }
    }
    int find(int v)
    {
        if(parent[v] == v) return v;
        return parent[v] = find(parent[v]);
    }
    void Union(int a, int b)
    {
        a = find(a);
        b = find(b);
        if(a != b)
        {
            if(size[a] < size[b])
            {
                 parent[a] = b;
                 size[b] = size[b] + size[a];
            }
            else 
            {
                parent[b] = a;
                size[a] += size[b];
            }
        }
    }
}
class Solution 
{
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) 
    {
        Disjoint ds = new Disjoint(V);
        
        for(int i = 0; i < adj.size(); i++)
        {
            for(int j = 0; j < adj.get(i).size(); j++)
            {
                if(adj.get(i).get(j) == 1) ds.Union(i,j);
            }
        }
        
        int count = 0;
        for(int i = 0; i < V; i++)
        {
            if(ds.find(i) == i) count++;
        }
        return count;
    }
};