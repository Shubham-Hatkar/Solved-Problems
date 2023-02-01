//{ Driver Code Starts
//Initial Template for Java

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
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    private int dir[][] = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    private void DFS(int sr, int sc, int grid[][], boolean vis[][])
    {
        int n = grid.length;
        int m = grid[0].length;
        
        vis[sr][sc] = true;
        
        for(int i = 0; i < 4; i++)
        {
            int nr = sr + dir[i][0];
            int nc = sc + dir[i][1];
            
            if(nr >= n || nc >= m || nr < 0 || nc < 0) continue;
            
            if(vis[nr][nc] == false && grid[nr][nc] == 1)
            {
                DFS(nr, nc, grid, vis);
            }
        }
    }
    public int closedIslands(int[][] grid, int n, int m)
    {
        boolean vis[][] = new boolean[n][m];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][0] == 1) 
                {
                    if(vis[i][0] == false && grid[i][0] == 1)
                    DFS(i, 0, grid, vis);
                }
                if(grid[i][m-1] == 1) 
                {
                    if(vis[i][m-1] == false && grid[i][m-1] == 1)
                    DFS(i, m-1, grid, vis);
                }
                if(grid[0][j] == 1) 
                {
                    if(vis[0][j] == false && grid[0][j] == 1)
                    DFS(0, j, grid, vis);
                }
                if(grid[n-1][j] == 1) 
                {
                    if(vis[n-1][j] == false && grid[n-1][j] == 1)
                    DFS(n-1, j, grid, vis);
                }
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(vis[i][j] == false && grid[i][j] == 1)
                {
                    DFS(i, j, grid, vis);
                    count++;
                }
            }
        }
        return count;
    }
}