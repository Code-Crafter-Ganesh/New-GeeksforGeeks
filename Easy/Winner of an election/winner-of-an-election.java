//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
          HashMap<String, Integer> map = new HashMap<>();
        for (String str: arr) map.put(str, map.getOrDefault(str, 0) + 1);
        
        int max_count = 0;
        String winner = "";
        for (String key: map.keySet()) {
            int val = map.get(key);
            if (val > max_count || (val == max_count && key.compareTo(winner) < 0)) {
                max_count = val;
                winner = key;
            }
        }
        
        return new String[]{winner, max_count + ""};
    }
}

