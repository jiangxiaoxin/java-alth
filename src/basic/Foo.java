package basic;

import java.lang.reflect.Constructor;
import java.util.Arrays;

import leetcode.ListNode;

public class Foo implements IHello {
	public String name;

	public Foo(String name) {
		this.name = name;
		System.out.println("构造函数");
	}

	public void hi() {

		System.out.println("Foo override hi() " + this.name);
	}

	public void hi(String msg) {
		System.out.println("Foo hi " + msg);
	}
	
	static void change(int[] nums) {
		// nums是局部变量，传递外层引用，在方法内可以指向别的数组
//		这里的传递引用的意思，是指传的外层的地址。
//		java 本质上方法参数都是按照值传递的.基础类型传的是对应的字面值,对象类型传递的是地址值.
		nums = new int[5];
		nums[0] = 100;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		Foo f = (Foo) obj;
		return f.name.equals(this.name);
	}
	

	public static void main(String[] args) throws Exception {
//		Class<Foo> cls = Foo.class;
//		Constructor<Foo> ctr = cls.getDeclaredConstructor(String.class);
//		Foo f = ctr.newInstance("cc");
//		f.hi();

//		int[][] arr = new int[3][3];
//		System.out.println(arr.length);
//		System.out.println(arr[0].length);
		
//		int[] nums = {1,2,3};
//		change(nums);
//		System.out.println(Arrays.toString(nums));

//		ListNode node = new ListNode();
//		System.out.println(node);
//
//		Integer num = 1;
//		System.out.println(num);

		Foo f = new Foo("foo");
		Foo g =  new Foo("foo");
		Foo h = g;
		System.out.println(f.equals(g));
//		System.out.println(g.equals(h));
//		System.out.println(f == g);
//		System.out.println(g == h);

		Foo a = null;
		Foo b = null;
		System.out.println(a == b);
//		System.out.println(a.equals(b)); // 直接报错了，a 是null，不能访问方法了
	
	}

}
