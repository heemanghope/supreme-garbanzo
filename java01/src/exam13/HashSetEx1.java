package exam13;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class HashSetEx1 {
	public static void main(String[] args){
		HashSet set = new HashSet();
		
		set.add("abc");
		set.add("abc");
		set.add(new Person("David",10));
		set.add(new Person("David",10));
		
		System.out.println(set);
	}
}

class Person{
	String name;
	int age;
	
	
//hashset은 오버라이딩 해시코드와 equals 필수
	@Override
	public int hashCode() {
		//int hash(Object... values); 가변인자
		return Objects.hash(name, age);
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Person))
			//부모가 자식 집을 찾아서 틀림
		return false;
		
		Person p =(Person)obj; //형변환
		//나자신 this의 이름과 나이를 p와 비교 
		return this.name.equals(p.name) && this.age ==p.age;
	}

	
	public Person(String name, int age) {
		
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return name +":"+age;
	}
}