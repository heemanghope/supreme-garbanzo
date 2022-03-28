package exam05;

public class Student {
/*학생 정보를 관리하기 위한 클래스
 * 이름,나이,학년 ,반 정보를 관리하는 클래스이다.
 */
	private String name;
	private int age;
	private int classRoom;
	private int classlevel;
	
	public Student(String name,int age) {
		this.name =name;
		this.age =age;
		
	}
	public Student(String name, int age, int classRoom, int classlevel) {
		this(name, age);
		this.classRoom=classRoom;
		this.classlevel=classlevel;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}
	public int getClasslevel() {
		return classlevel;
	}
	public void setClasslevel(int classlevel) {
		this.classlevel = classlevel;
	}
}
