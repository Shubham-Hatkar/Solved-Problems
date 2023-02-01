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
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        int dir[][] = {{-2,-1}, {-1,-2}, {-2,1}, {-1,2}, {1,-2}, {2,-1}, {1,2}, {2,1}};
        
        boolean vis[][] = new boolean[N+1][N+1];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{KnightPos[0], KnightPos[1]});
        
        vis[KnightPos[0]][KnightPos[1]] = true;
        
        int level = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                int temp[] = q.remove();
                int r = temp[0];
                int c = temp[1];
                
                if(r == TargetPos[0] && c == TargetPos[1]) return level;
                
                for(int j = 0; j < 8; j++)
                {
                    int nr = r + dir[j][0];
                    int nc = c + dir[j][1];
                    if(nr > N || nc > N || nr < 1 || nc < 1) continue;
                    
                    if(vis[nr][nc] == false)
                    {
                        q.add(new int[]{nr,nc});
                        vis[nr][nc] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}