package exam02;

//자바의 기본 기능 외의 추가 기능을 사용하기 위해 작성하는 구문
import java.util.*;


public class Sample01 {

	// 멤버 변수 : 값을 저장하기 위한 공간. 클래스 안에 만들어진 변수를 멤버 변수라 칭함. 
	private int number = 0;
	private String name ="hyun";
	
	
	//생성자 : 클래스명과 동일한 이름을 사용하는 메서드를 생성자라고 한다.(생성자는 리턴 타입이 없다.)
	//자바에서는 클래스를 사용할 떄 반드시 객체로 생성하여 사용하여 한다. 이 때 객체를 생성하기 위해 필요한 것이 생성자이다.
	public Sample01() {
	     // 현재 이 생성자는 기본생성자로 클래스에 작성을 하지 않아도 기본적으로 생성되어 사용됨.   
	}
	
	
	
	//멤버 메서드(함수) : 클래스 안에 만들어진 메서드(함수)를 멤버 메서드라 칭한다.
	public void method() {
		int x = 0;
		String c = "문장"; 
	}
	
	//메인 메서드 : 자바 프로그램에서 프로그램을 실행하기 위한 시작점으로 사용
	public static void main(String[] args) {
		//지역변수 : 특정 지역 안에서만 사용되는 변수
		int i =0;
		String s = "문자열";
		
		// TODO Auto-generated method stub
        //한 줄 주석 : 코드로 실행하지 않는 문장
		/*

		 * 여러 줄 주석  (여러 줄의 주석): 코드로 실행하지 않는 문장  
           여러 줄에 대해서도 주석으로 처리해 준다.
		*/  
		System.out.println("자바 기본 출력 코드");
	}

}