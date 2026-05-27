import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Map<Integer, Integer> phoneketmon = new HashMap<>();
        
        for(int num : nums){
            phoneketmon.put(num, phoneketmon.getOrDefault(phoneketmon,0)+1);   
        }
        
        int max = nums.length / 2;
        
        if(max < phoneketmon.size()){
            return max;
        }
        
        return phoneketmon.size();
    }
}
