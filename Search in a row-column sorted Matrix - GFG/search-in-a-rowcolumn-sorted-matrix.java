//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG{
	public static void main(String args[]) throws IOException { 
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
       		int rows=sc.nextInt();
       		int columns=sc.nextInt();
			
			int matrix[][]=new int[rows][columns];
          
        	for(int i=0; i<rows;i++){            
            	for(int j=0; j<columns;j++){
                	matrix[i][j]=sc.nextInt();
            	}
         	}
         	int target = sc.nextInt();
         	
			Solution x = new Solution();
			
			if (x.search(matrix, rows, columns, target)) 
				System.out.println(1); 
			else
				System.out.println(0); 
			t--;
		}
	} 
}
// } Driver Code Ends




class Solution 
{ 
    //Function to search a given number in row-column sorted matrix.
	static boolean search(int matrix[][], int n, int m, int x) 
	{  
	    int r = matrix.length;
	    int c = matrix[0].length;
	    
	    int row = -1;
	    while(++row < r)
	    {
	        if(matrix[row][c-1] < x) continue;
	        if(matrix[row][0] > x) return false;
	        int start = 0;
	        int end = c - 1;
	        while(start <= end)
	        {
	            int mid = (start + end) / 2;
	            if(matrix[row][mid] == x) return true;
	            if(matrix[row][mid] < x) start = mid + 1;
	            else end = mid - 1;
	        }
	    }
	    return false;
	} 
} 
