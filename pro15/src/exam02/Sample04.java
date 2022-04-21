package exam02;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Person{
	private String name;
	private int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
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

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(name, other.name);
	}

	
	//hashcode와 equals ..오버라이드..중복된 객체를 빼고 싶을때 만들어야함.
	
	
}

public class Sample04 {

	public static void main(String[] args) {
		Set<Person> pSet = new HashSet<Person>();
		pSet.add(new Person("홍길동",25));
		pSet.add(new Person("김철수",23));
		pSet.add(new Person("김철수",21));
		pSet.add(new Person("박주왕",26));
		//객체는 다르지만 , 값과 속성은 같다. new 객체생성 연산자.다름--일부/모두 중복으로 만들고 싶다..
		System.out.println(pSet);
		
	}

}
