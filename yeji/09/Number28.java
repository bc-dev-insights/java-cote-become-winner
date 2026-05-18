import java.util.*;

class Solution {

    public static Map<Integer, List<Integer>> edgeMap;
    public static int answer;

    public int solution(int[] info, int[][] edges) {
        answer = 0;
        edgeMap = new LinkedHashMap<>();

        for (int[] edge : edges) {
            List<Integer> nodeList = edgeMap.getOrDefault(edge[0], new LinkedList<>());
            nodeList.add(edge[1]);
            edgeMap.put(edge[0], nodeList);
        }

        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0);

        dfs(nextNodes, info, 0, 0);

        return answer;
    }

    public static void dfs(List<Integer> nextNodes, int[] info, int sheep, int wolf) {
        for (int i = 0; i < nextNodes.size(); i++) {
            int node = nextNodes.get(i);

            int nextSheep = sheep;
            int nextWolf = wolf;

            if (info[node] == 0) nextSheep++;
            else nextWolf++;

            if (nextWolf >= nextSheep) continue;

            answer = Math.max(answer, nextSheep);

            List<Integer> candidates = new ArrayList<>(nextNodes);
            candidates.remove(i);

            if (edgeMap.get(node) != null) {
                candidates.addAll(edgeMap.get(node));
            }

            dfs(candidates, info, nextSheep, nextWolf);
        }
    }
}
