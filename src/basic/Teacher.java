package basic;

public class Teacher extends Person {

	private String[] lessons;
	public Teacher(String name, Integer age) {
		super(name, age);
	}
	
	public String[] getLessons() {
		return lessons;
	}

	public void setLessons(String[] lessons) {
		this.lessons = lessons;
		
		
	}
	
	@Override
	public String getName() {
		return "im teacher0000:" + super.getName();
	}
	
	@Override
	public String toString() {
		return this.getClass().getName() + "::--->" + super.toString();
	}
	
//	子类必须实现父类中的抽象方法，否则子类也必须声明成abstract，这样子类也就成了抽象类，不能直接实例化
	public void hi(String msg) {
		System.out.println("teacher hi" + msg);
	}

	

}
