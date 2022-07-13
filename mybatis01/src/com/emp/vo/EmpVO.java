package com.emp.vo;

public class EmpVO {          
   private int empId; //컬럼명과 가급적 동일하게//멤버변수(필드) 지역변수x
   private String firstName;
   private String lastName;
   
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
  
}
