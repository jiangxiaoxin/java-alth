import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class 逆波兰表达式求值 {
	
	public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for(String token : tokens) {
			switch (token) {
				case "+" -> stack.push(stack.pop() + stack.pop());
				case "-" -> stack.push(-stack.pop() + stack.pop());
				case "*" -> stack.push(stack.pop() * stack.pop());
				case "/" -> {
					int b = stack.pop();
					int a = stack.pop();
					stack.push(a / b);
				}
				default -> stack.push(Integer.parseInt(token));
			}
        }
        return stack.peekFirst();
    }

	public static void main(String[] args) {
//		String[] tokens = {"2","1","+","3","*"};
//		String[] tokens = {"4","13","5","/","+"};
		String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		int result = evalRPN(tokens);
		System.out.println(result);

	}

}
