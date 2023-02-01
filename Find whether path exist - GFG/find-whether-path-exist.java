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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}
// } Driver Code Ends



class Solution
{
    int dir[][] = {{0,-1}, {-1,0}, {0,1}, {1,0}};
    private boolean DFS(int sr, int sc, int grid[][], boolean vis[][])
    {
        int n = grid.length;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        vis[sr][sc] = true;
        
        while(q.size() > 0)
        {
            int temp[] = q.remove();
            int r = temp[0];
            int c = temp[1];
            if(grid[r][c] == 2) return true;
            
            for(int i = 0; i < 4; i++)
            {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                
                if(nr >= n || nc >= n || nr < 0 || nc < 0) continue;
                if(vis[nr][nc] == false && grid[nr][nc] != 0)
                {
                   q.add(new int[]{nr,nc});
                   vis[nr][nc] = true;
                }
            }
        }
        return false;
    }
    public boolean is_Possible(int[][] grid)
    {
        int n = grid.length;
        boolean vis[][] = new boolean[n][n];
        boolean ans = false;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(vis[i][j] == false && grid[i][j] == 1)
                {
                    ans = DFS(i, j, grid, vis);
                }
            }
        }
        return ans;
    }
}