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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        boolean vis[][] = new boolean[n][m];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 1)
                {
                    q.add(new int[]{i,j});
                    vis[i][j] = true;
                }
            }
        }
        
        int dir[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int level = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                int temp[] = q.remove();
                int r = temp[0];
                int c = temp[1];
                grid[r][c] = level;
                for(int j = 0; j < 4; j++)
                {
                    int nr = r + dir[j][0];
                    int nc = c + dir[j][1];
                    if(nr >= n || nc >= m || nr < 0 || nc < 0) continue;
                    if(vis[nr][nc] == false)
                    {
                        q.add(new int[]{nr,nc});
                        vis[nr][nc] = true;
                    }
                }
            }
            level++;
        }
        return grid;
    }
}






