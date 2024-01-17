//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0; i<n; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> res = ob.uniquePerms(arr,n);
            for(int i=0; i<res.size(); i++)
            {
                for(int j=0; j<n; j++)
                {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
         Set<ArrayList<Integer>> uniquePermsSet = new HashSet<>();

        // Generate permutations and add them to the set
        permute(arr, 0, n, uniquePermsSet);

        // Convert the set to a list and sort
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(uniquePermsSet);
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
                    int cmp = Integer.compare(o1.get(i), o2.get(i));
                    if (cmp != 0) return cmp;
                }
                return Integer.compare(o1.size(), o2.size());
            }
        });

        return result;
    }

    private static void permute(ArrayList<Integer> arr, int index, int n, Set<ArrayList<Integer>> set) {
        if (index == n) {
            set.add(new ArrayList<>(arr)); // Add a copy of the current permutation
            return;
        }

        for (int i = index; i < n; i++) {
            Collections.swap(arr, i, index); // Swap the elements
            permute(arr, index + 1, n, set); // Recurse for the next element
            Collections.swap(arr, i, index); // Swap back
        }
        
    }
};