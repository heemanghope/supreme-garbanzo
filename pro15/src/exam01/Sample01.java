package exam01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

class Person implements Comparable<Person>{//인터페이스 상속시켜서 implement등록해서 비교
	
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name=name;
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
	public int compareTo(Person o) {
		if(this.getName().compareTo(o.getName()) >0) {
			return 1;
		}else if(this.getName().compareTo(o.getName()) <0) {
			return-1;
		}else {	
			if(this.getAge() > o.getAge()) {
				return 1;
			}else if(this.getAge() < o.getAge()) {
				return -1;
			}
		}
		return 0;
		
	}
	
	
}


public class Sample01 {

	public static void main(String[] args) {
		/*
		 * List 컬렉션 - ArrayList
		 */

		 //List<Integer> aList = new ArrayList<Integer>();
        //List<Integer> aList = new Vector<Integer>();   
        List<Integer> aList = new LinkedList<Integer>();   
		
		 aList.add(100);
		 System.out.println(aList);
		 aList.add(200);
		 System.out.println(aList);
		 aList.add(300);
		 System.out.println(aList);
		 
		 aList.add(2, 400);
		 System.out.println(aList);
		 
		 List<Integer> bList = new ArrayList<Integer>();
		 bList.add(500);bList.add(600);bList.add(700);
		 
		 
		 aList.addAll(bList);
		 System.out.println( aList);
		 
		 Integer result1 = aList.set(2,350);
		 System.out.println(result1 +" | "  +  aList);
		 result1 = aList.set(3,450);
		 System.out.println(result1 +" | "  +  aList);
		 
		 boolean result2 = aList.contains(Integer.valueOf(200));
		 System.out.println(result2);
		 
		 int result3 = aList.indexOf(Integer.valueOf(300));
		 System.out.println(result3);
		 
		 result2=bList.isEmpty();
		 System.out.println(result2);
		 
		 bList.clear();//저장된 객체 모두 삭제
		 result2=bList.isEmpty();//비어져있나?
		 System.out.println(result2);//모두 없으므로 true
		 
		 result3 = aList.size();
		 System.out.println(result3);
		 
		 System.out.println(aList);
		 result1 =aList.remove(0);
		 System.out.println(result1 + " "+ aList);//삭제된 100이 반환되어있음
		 //리스트에 있던 100(0)을 임시로 삭제해두었다가 나중에 꺼내서 활용할 수 있음.
		 //인덱스번호로 삭제하기.
		 
		 aList.remove(Integer.valueOf(600));
		 System.out.println(aList);
		 
		 
		 //System.out.println(aList.get(0));순차적으로 증가하는 인덱스번호 활용.
		 
		 for(int i=0; i<aList.size(); i++) {//size메서드와 반복문을 활용해서 사용
		 System.out.println(aList.get(i));
		 }
		 
		 
		 System.out.println("<<<<< Iterator 사용>>>>>");
		 Iterator<Integer> iter =aList.iterator();
		 while(iter.hasNext()) {
			 Integer i1 =iter.next();
			 System.out.println(i1);
		 }
		 
		 System.out.println("<<<<< for each 문 >>>>>");
		 for(Integer i2: aList) {
			 System.out.println(i2);
			 //배열에서 iterator를 사용하여 쓸수도 있음.
		
		 }
		 
		 
		
		 
		Collections.reverse(aList);//그냥 역순으로! 정렬은 아님
		 System.out.println(aList);
		
		 
		//정렬해보기 
		Collections.sort(aList);
		 System.out.println(aList);//오름차순
		 
		 //내림차순은 sort후 reverse 를 한다.
		 	Collections.sort(aList);
		 	Collections.reverse(aList);
		 	System.out.println(aList);
	
		 	
		 	
		 	
    aList.add(3,150);
    aList.add(1,250);
    aList.add(4,550);
    
    System.out.println(aList);
  
		//활용하기 	
	Collections.sort(aList,new Comparator<Integer>() {

		@Override
		public int compare(Integer x, Integer y) {//정렬을하기위한 기준만들기
			if(x>y) {
			    return 1;
			}else if(x<y) {
				return -1;
			}else {
				return 0;
			}//오름차순 1,-1,0순  // 내림차순 -1,1,0순
			
		}
		
	});
	
	   System.out.println(aList);
	   
	   
	   List<Person> pList = new ArrayList<Person>();
	   pList.add(new Person("홍길동", 23));
	   pList.add(new Person("김철수", 23));
	   pList.add(new Person("김철수", 21));
	   pList.add(new Person("김철수", 25));
	   
	   System.out.println(pList);
	   Collections.sort(pList);
	   Collections.sort(pList, new Comparator<Person>() {//정렬하기위해서는 값을 비교

		@Override
		public int compare(Person  x, Person y) {
			if(x.getName().compareTo(y.getName()) >0) {
				return 1;
			}else if(x.getName().compareTo(y.getName()) <0) {
				return-1;
			}else {	
				if(x.getAge() >y.getAge()) {
					return 1;
			}else if(x.getAge() < y.getAge()) {
				    return -1;
				}
			}
			return 0;
		}
		   
	   });
	   System.out.println(pList);
	}   
}
