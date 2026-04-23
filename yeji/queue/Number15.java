import java.util.ArrayDeque;
import java.util.Queue;

/**
* 요세푸스 문제 
* 
*/
public class Number15 {

    public static void main(String[] args) {
        System.out.println(solution(5, 2));
    }


    public static int solution(int n, int k){
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=1; i<=n ;i++){
            queue.offer(i);
        }

        while (queue.size() > 1){
            for(int i=1; i<k; i++){
                queue.offer(queue.poll());
            }
            queue.poll();
        }

        return queue.poll();
    }

}
