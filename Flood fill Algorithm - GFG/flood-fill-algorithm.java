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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    private int dir[][] = {{1,0}, {-1,0}, {0,-1}, {0,1}};
    private void DFS(int sr, int sc, int prevColor, int newColor, int grid[][], boolean vis[][])
    {
        int n = grid.length;
        int m = grid[0].length;
        
        vis[sr][sc] = true;
        grid[sr][sc] = newColor;
        
        for(int i = 0; i < 4; i++)
        {
            int nr = sr + dir[i][0];
            int nc = sc + dir[i][1];
            
            if(nr >= n || nc >= m || nr < 0 || nc < 0) continue;
            if(grid[nr][nc] == prevColor)
            {
                DFS(nr, nc, prevColor, newColor, grid, vis);
            }
        }
    }
    public int[][] floodFill(int[][] grid, int sr, int sc, int newColor)
    {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean vis[][] = new boolean[n][m];
        DFS(sr, sc, grid[sr][sc], newColor, grid, vis);
        return grid;
    }
}