package LeetCode;


import java.util.*;

class Solution {
    public boolean isStraight(int[] nums) {
        int low=13,high=0;
        Arrays.sort(nums);
        int i=0;
        while(i<5&&nums[i]==0) i++;
        if(i==5) return true;
        if(nums[4]-nums[i]>4) return false;
        while (i<4){
            if(nums[i]==nums[i+1]) return false;
            i++;
        }
        return true;

    }
}