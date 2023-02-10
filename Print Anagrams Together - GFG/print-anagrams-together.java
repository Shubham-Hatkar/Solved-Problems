//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    int t=Integer.parseInt(br.readLine().trim());
	    while(t > 0)
	    {
	        int n= Integer.parseInt(br.readLine().trim());
	        String x = br.readLine().trim();
	        String string_list[] = x.split(" ",n);
	        
	        Solution ob = new  Solution();
	        
	        List <List<String>> ans = ob.Anagrams(string_list);
	        
	        Collections.sort(ans, new Comparator<List<String>>(){
            public int compare(List<String> l1, List<String> l2) {
                    String s1 =  l1.get(0);
                    String s2 = l2.get(0);
                    
                    return s1.compareTo(s2);
                }
            });
	        
	        for(int i=0;i<ans.size();i++)
	        {
	            for(int j=0;j<ans.get(i).size();j++)
	            {
	                System.out.print(ans.get(i).get(j) + " ");
	            }
	            System.out.println();
	        }
	       
	       
            t--;
	    }
	}
    
}

// } Driver Code Ends


//User function Template for Java

class Solution 
{
    private String sort(String s)
    {
        char str[] = s.toCharArray();
        Arrays.sort(str);
        return new String(str);
    }
    public List<List<String>> Anagrams(String[] str) 
    {
        HashMap<String,List<String>> hm = new HashMap<>();
        
        for(int i = 0; i < str.length; i++)
        {
            String original = str[i];
            String sorted = sort(original);
            
            if(hm.containsKey(sorted))
            {
                List<String> old = hm.get(sorted);
                old.add(original);
                hm.put(sorted,old);
            }
            else
            {
                List<String> newlist = new ArrayList<>();
                newlist.add(original);
                hm.put(sorted,newlist);
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(String key : hm.keySet())
        {
            ans.add(hm.get(key));
        }
        return ans;
    }
}
