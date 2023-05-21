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
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] sortedArrayToBST(int[] nums)
    {
        int[] ans = new int[nums.length];
        if(nums.length==0) return ans;
        
        int start = 0;
        int end = nums.length-1;
        
        sortedArrayToBST(nums, start, end, ans);
        return ans;
    }
    
    int i = 0;
    void sortedArrayToBST(int[] nums, int start, int end, int[] ans) {
        if (start > end) return;
        
        int mid = start + (end-start)/2;
        ans[i++] = nums[mid];
        
        sortedArrayToBST(nums, start, mid-1, ans);
        sortedArrayToBST(nums, mid+1, end, ans);
    }
    
}