package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void permute(int[] candidates,int i ,List<List<Integer>> ans ,List<Integer> curr, int target){
        if(target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(target<0)return;

        for(int j=i;j<candidates.length;j++){
            curr.add(candidates[j]);
            permute(candidates,j,ans,curr,target-candidates[j]);
            curr.removeLast();
        }

    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        permute(candidates,0,ans,curr,target);
        return ans;
    }
}
