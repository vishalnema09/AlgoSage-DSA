package ArraysHARD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for(int i : nums){
            map1.put(i , map1.getOrDefault(i , 0) + 1);
        }
        List<Integer> element = new ArrayList<>();
        int temp = (nums.length / 3);
        for (var entry : map1.entrySet()) {
            int elem=entry.getKey();
            int count=entry.getValue();
            if(temp<count){
                element.add(elem);
            }
        }
        return element;
    }
}
