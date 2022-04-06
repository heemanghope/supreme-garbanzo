package exam02;

import java.util.Objects;

public class Person {
	private String name;
	private int age;
	private char gender;
	
	public Person(String name) {
		this.name = name;
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
	
	public String getGender() {  
		if(gender == 'M') {       
			return "남";
		} else {
			return "여";
		}
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override      //모든 객체는 tostring을 가지고 있다고 본다.
	public String toString() {//어떠한 객체인지는 알지만 보여주고 싶은것, 정의하기
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) { //외부에서 전달한 객체랑 내가가지고있는 값이랑 비교하는것이다.
		if (this == obj)          //객체의 참조값.
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj; //다운 캐스팅
		return age == other.age && Objects.equals(name, other.name);
	}
	
}
