package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public void powerSet(int nums[],int i, List<Integer>curr,List<List<Integer>>ans){
        if(i==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        powerSet(nums, i+1, curr, ans);

        curr.remove(curr.size()-1);
        powerSet(nums,i+1,curr,ans);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        powerSet(nums,0,curr,ans);
        return ans;
    }
}
