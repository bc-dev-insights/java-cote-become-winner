import java.util.HashMap;
import java.util.Map;

class Solution {


    public static boolean solution(int[] arr, int target) {
        boolean answer = false;
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : arr) {
            map.put(a, 0);
        }

        for (Integer i : map.keySet()) {
            int findTarget = target - i;
            if (map.getOrDefault(findTarget, -1) != -1 && i != findTarget) {
                return true;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 8}, 6));
        System.out.println(solution(new int[]{2, 3, 5, 9}, 10));
    }

}
