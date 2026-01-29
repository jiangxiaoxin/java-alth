package leetcode;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class 队列的使用 {

	/**
	 * Queue接口里定义了两套api ，总体分为报错和不报错两类：add remove element和offer，poll，peek
	 * 实现这个接口的类，常用的是 LinkedList 和 ArrayDeque. 
	 * ArrayDeque 是双端队列，数组实现，不能添加null
	 * LinkedList 有头尾指针，所以天然可当Queue 用
	 * 除此之外，还有很多种不同的 Queue 实现
	 */
	public static void main(String[] args) {
//		Queue<Integer> queue = new LinkedList<Integer>();
//		queue.add(1);
//		queue.add(2);
//		queue.add(3); // 1,2,3
//		System.out.println(queue.element());//1
//		queue.offer(null);//1,2,3,null
//		System.out.println(queue.size());//4
//		System.out.println(queue.peek());//1
//		System.out.println(queue.poll());//1
//		System.out.println(queue.poll());//2
//		System.out.println(queue.poll());//3
//		System.out.println(queue.poll());//null
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
//		queue.add(null); // 内部实现里判断如果传入null 就报错
		queue.add(1);
		queue.add(33);
		queue.poll();
		queue.poll();
		queue.poll();

	}

}
