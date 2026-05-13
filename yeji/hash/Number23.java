import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String[] id_list, String[] reports, int k) {
        int[] answer = new int[id_list.length];
        
        Set<String> reportSet = new HashSet<>();
        for(String report : reports){
            reportSet.add(report);
        }
        
        // 신고한 애들
        Map<String, List<String>> stopIdMap = new HashMap<>();
        // 잠김애들
        Map<String, Integer> blackListMap = new HashMap<>();
        
        for(String report : reportSet){
            String[] target = report.split(" ");
            String userId = target[0];
            String blackId = target[1];
            
            blackListMap.put(blackId, blackListMap.getOrDefault(blackId,0)+1);
            
            List<String> data = stopIdMap.getOrDefault(userId, new ArrayList<>());
            data.add(blackId);
            stopIdMap.put(userId, data);
        }
        
        Map<String,Integer> result = new HashMap<>();
        
        for(String key : blackListMap.keySet()){
            if(blackListMap.get(key) >= k){
                for(String id : stopIdMap.keySet()){
                    if(stopIdMap.get(id).contains(key)){
                        result.put(id, result.getOrDefault(id, 0)+1);
                    }
                }
            }
        }
    
        for(int i=0; i<id_list.length; i++){
            if(result.get(id_list[i]) != null){
                answer[i] = result.get(id_list[i]);
            }
        }
        
        return answer;
    }
}
