package exam01;

public class Parent { //캡슐화 private 접근제한자 //같은 클래스 안에서만 가능하다.접근불가능 
	//상속은 되어있는데 접근제한자가 private -ex. 부모님 지갑에서 허락. 1000원 ->가져가 ,허락이 public 
	//간접접근...getter setter
   private int number =10; //직접적으로는 안되지만 요청하면 해주겟다.
   
   
   public Parent(int number) {
	   this.number =number; //생성자는 상속이 안됩니다. 
	   //부모가 매개변수가 있는 생성자를 생성하게 되면 기본 생성자는 자동으로 생성되지 않는다.
	   
	   
   }
   public int getNumber() {//==
	  System.out.println("부모의 getNumber 메서드 시작");
	  System.out.println("부모의 getNumber 메서드 끝");
	  return number;
   }
   
   public void setNumber(int number) {//허락을 구하는것.   private,public 모두 상속가능 단, 직접 private접근이 안됨.
	   this.number=number;
   }
}
