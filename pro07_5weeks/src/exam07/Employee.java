package exam07;

public class Employee {
       private String name;
       private int  age;
       private char gender;
       private int salary;
       
    
       
       
	public Employee(String name, int age) { //생성자를 만들어놓는것. constructor
		                                           //매개변수가 있는 생성자를 만들었기때문에
		                             //  기본생성자x 다른 곳에서 에러가 뜬다.
		this.name = name;
		this.age = age;
	}

	
	public void payMonth() { //급여
		double pay = (double)getSalary()/12;//연봉에 12를 나눔.
		System.out.printf("월급 : %,d 원 지급하였습니다.\n",(int)( pay * 10000));
		
	}
	
	public void bonus(int month) {//보너스
		double bonus = getSalary() * 0.25;
		System.out.printf("보너스 %,d 원 지급하였습니다. \n ",(int)(bonus * 10000));
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
	
	public int getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
       
}






