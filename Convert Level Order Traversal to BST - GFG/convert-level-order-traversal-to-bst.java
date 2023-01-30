//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Main {
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            GFG obj = new GFG();
            Node tree = obj.constructBST(arr);
            preorder(tree);
            System.out.println();
        }
	}
	
	 public static void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}


// } Driver Code Ends


//User function Template for Java

class Info
{
    int min;
    int max;
    Node node;
    Info(int min, int max, Node node)
    {
        this.min = min;
        this.max = max;
        this.node = node;
    }
}
class GFG 
{
    //Function to construct the BST from its given level order traversal.
    public Node constructBST(int[] arr)
    {
        Queue<Info> q = new LinkedList<>();
        Node root = new Node(arr[0]);
        Info left = new Info(Integer.MIN_VALUE, root.data, root);
        Info right = new Info(root.data, Integer.MAX_VALUE, root);
        q.add(left);
        q.add(right);
        
        int i = 1;
        while(i < arr.length)
        {
            Info temp = q.remove();
            int min = temp.min;
            int max = temp.max;
            Node node = temp.node;
            
            if(arr[i] > min && arr[i] < max)
            {
                if(arr[i] < node.data)
                {
                    Node nn = new Node(arr[i]);
                    node.left = nn;
                    Info l = new Info(min, nn.data, nn);
                    Info r = new Info(nn.data, max, nn);
                    q.add(l);
                    q.add(r);
                }
                else
                {
                    Node nn = new Node(arr[i]);
                    node.right = nn;
                    Info l = new Info(min, nn.data, nn);
                    Info r = new Info(nn.data, max, nn);
                    q.add(l);
                    q.add(r);
                }
                i++;
            }
        }
        return root;
    }
}




