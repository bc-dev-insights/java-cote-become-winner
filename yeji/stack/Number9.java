import java.util.Stack;

public class Number9 {

    public static void solution(int data) {

        StringBuffer answer = new StringBuffer();
        Stack<Integer> stack = new Stack<>();

        while (data > 1) {
            stack.push(data % 2);
            data = data / 2;
        }

        answer.append(data);

        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }

        System.out.println(answer);
    }


    public static void main(String[] args) {
        solution(10);
        solution(27);
        solution(12345);
    }
}
