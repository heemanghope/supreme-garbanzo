package exam02;

public class Teacher extends Person {
	private int classLevel;	// 담당 학년
	private int classRoom;	// 담당 반
	private String subject;	// 담당 과목
	
	public Teacher(String name) {//매개변수가 있는 생성자를 만들어주기.
		super(name);//생성자는 상속이 안된다.
	}
	
	public int getClassLevel() {
		return classLevel;
	}
	
	public void setClassLevel(int classLevel) {
		this.classLevel = classLevel;
	}
	
	public int getClassRoom() {
		return classRoom;
	}
	
	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public String getGender() {
		return super.getGender() + "선생님";
	}

	@Override
	public String toString() {
	return "Teacher [name=" + getName() + ", age=" + getAge() + ", gender=" + getGender()
	+ ", classLevel=" + classLevel + ", classRoom=" + classRoom + "]";
	}

	
}

