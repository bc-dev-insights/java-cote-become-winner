import java.util.Stack;

/**
* 크레인 인형 뽑기 
* https://school.programmers.co.kr/learn/courses/30/lessons/64061
*/
class Number13 {
    
    public static Stack<Integer> stack;
    public static int answer;
    
    public int solution(int[][] board, int[] moves) {
        answer = 0;
        stack = new Stack<>();
        
        for(int move : moves){
            clawMachineGame(move, board);
        }
        
        return answer;
    }

    // 인형뽑기
    private void clawMachineGame(int target, int[][] board){
        int x = board.length;
        int y = board[0].length;
        target--;
        int targetX = 0;
        while(targetX < x){
            int compare = board[targetX][target];
             if(compare != 0){
                compareStack(compare);
                board[targetX][target] = 0;
                return;
            }
            targetX++;
        }
    }

    // 겹치는 인형 제거하기
    private void compareStack(int compare){
        
        if(!stack.isEmpty() && stack.peek() == compare){
            answer += 2;
            stack.pop();
            return;
        }
       
        stack.push(compare);
    }
    
}
