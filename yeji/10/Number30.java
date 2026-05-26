// 유니온 - 파인드 구현하기

class Solution {

    public static int[] nums;

    private static void union(int a, int b) {
        int targetA = find(a);
        int targetB = find(b);
        if (targetA != targetB) {
            nums[targetA] = targetB;
        }
    }

    private static int find(int a) {
        if (a == nums[a]) {
            return a;
        }
        return nums[a] = find(nums[a]);
    }


    public static void main(String[] args) {
        int k = 3;
        int[][] operations = {{0, 0, 1}, {1, 1, 2}, {0, 1, 2}, {1, 0, 2}};
        nums = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            nums[i] = i;
        }

        for (int[] operation : operations) {
            // union
            if (operation[0] == 0) {
                union(operation[1], operation[2]);
            } else {
                // find
                int targetA = find(operation[1]);
                int targetB = find(operation[2]);
                if (targetB != targetA) {
                    System.out.printf("False ");
                } else {
                    System.out.printf("True");
                }
            }
        }

    }


}
