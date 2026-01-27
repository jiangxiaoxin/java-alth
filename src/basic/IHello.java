package basic;

/**
 * 接口里声明不同的方法，不提供具体实现。
 * 实现的子类需要自己实现这些方法，不实现就会提示报错。
 */

public interface IHello {
//	接口里的方法可以有默认实现，需要前面加 default表示

	default void hi() {
		System.out.println("hi...");
	}
	
	void hi(String msg);
}
