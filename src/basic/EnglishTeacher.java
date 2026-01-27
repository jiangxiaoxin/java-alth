package basic;

public class EnglishTeacher extends Teacher {

	public EnglishTeacher(String name, Integer age) {
		super(name, age);
		String[] lessons = {"english"};
		this.setLessons(lessons);
		
		super.getName();
//		Teacher.super.hi();
	}
	
	

}
