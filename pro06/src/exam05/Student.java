package exam05;

public class Student {
/*학생 정보를 관리하기 위한 클래스
 * 이름,나이,학년 ,반 정보를 관리하는 클래스이다.
 */
	private String name;
	private int age;
	private int classRoom;
	private int classlevel;
	
	private Student(String name,int age) {//이름, 나이,학년 ,반 생성자가 미리 공개되어있음. StudentList안에!!!
		  // 그러므로 public 대신에 private을 써준다.
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
