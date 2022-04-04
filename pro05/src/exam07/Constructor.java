package exam07;

public class Constructor {
	public int num1;
	public int num2;
	public int num3;
	public int num4;
	
	//기본 생성자
	public Constructor() {} //메서드
	
	public Constructor(int num1) {  //매개변수가 있는 생성자는 기본생성자x                  
		this.num1 = num1;//멤버변수,매개변수가 이름이 같아서 구분하기 어려움. this 사용하기 클래스안에 매개변수

	}//this는 객체의 자기 자신이다.라고도 의미한다.  //이미 num1 생성자가 있다. 재사용하고자하는 목적이 있음.
	
	public Constructor(int num1,int num2) {
		   this(num1);  //그냥 함수처럼 쓰는 것,점찍기 말것
		   this.num2 = num2;
	}
	
	public Constructor(int num1,int num2,int num3) {
			this (num1,num2);
			this.num3 = num3;
			
	}
   public Constructor(int num1,int num2,int num3, int num4) {
				this (num1,num2,num3);  //재사용을 위해서 this 라는 코드를 활용,,반드시 첫번쨰줄에 와야한다!
				this.num4 = num4;   //오버로딩 : 타입과 수가 달라야한다.
	
}
}
