package basic;


// 只要有方法是抽象的，类就必须是抽象的
// 抽象类可以没有抽象方法，只声明是个抽象类，这就是闲的
public abstract class Person {

	private String name;
	private Integer age;
	public Person(String name, Integer age) {
		this.setName(name);
		this.setAge(age);
		
//		this.name = "123";
	}
	
//	public void hi(String msg) {
//		System.out.println("im " + this.getName() + ", age =" + this.getAge() + '.' + msg);
//	}
	
	
//	抽象的方法不能提供方法体，只能由子类自己实现
	public abstract void hi(String msg);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	
	public void setAge(Integer age) {
		this.age = age;
	}
}
