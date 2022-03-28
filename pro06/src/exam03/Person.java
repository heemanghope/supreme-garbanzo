package exam03;

public class Person {
   private String name;
   
   public Person() {}   //기본 생성자를 위한 것
   public Person(String name) {//매개변수가 있는 것????
	   this.name =name;
	   
   }
   
   
   public String getName() {//실제이름
	   return this.name;
	   
   }
   
   public void setName(String name) {
	   this.name=name;
	   
   }
   
}
