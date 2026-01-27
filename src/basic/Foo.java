package basic;

public class Foo implements IHello {
	public String name;
	public Foo(String name) {
		this.name = name;
	}
	
	public void hi() {
		
		System.out.println("Foo override hi()" + this.name);
	}
	
	public void hi(String msg) {
		System.out.println("Foo hi " + msg);
	}

}
