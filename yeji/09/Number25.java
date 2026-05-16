class Solution {


    public static String[] solution(int[] nodes) {
        String[] answer = new String[3];
        answer[0] = preorder(nodes, 0).trim();
        System.out.println(answer[0]);

        return answer;
    }

    private static String preorder(int[] nodes, int i) {

        if (i >= nodes.length) {
            return "";
        }

        return nodes[i] + " " + preorder(nodes, 2 * i + 1) + preorder(nodes, 2 * i + 2);
    }

    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 4, 5, 6, 7});
    }


}
