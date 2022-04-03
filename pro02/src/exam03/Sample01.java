package exam03;
  
import java.util.Scanner;

public class Sample01 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력을 받기 위한 Scanner 클래스
		 *        - 콘솔(터미널) 환경에서 사용자 입력을 받기 위해 사용.
		 *        -기본 기능이 아니기 때문에 import 구문이 필요하다. -> import java.util.Scanner;
		 */
		
		// Scanner 객체 생성
		Scanner sc = new Scanner(System.in); // new 라는 연산자로 새로운 객체(Scanner)를 생성한다.system.in 사용자 (입력)!
		//객체타입, 변수명,  새로운객체생성                                         // 반대로 콘솔창에 system.out 을 하면 (출력)
	
        // 사용자 입력을 받고 재사용을 위해 변수에 저장.
		System.out.print("이름을 입력하세요. : ");
	    String sInput = sc.next(); //다음 토큰을 문자열로 return
	      //2.여기에 저장!              //1.홍길동이라고 입력하면
	    // 사용자 입력 값을 출력
	    
	    System.out.println("사용자 입력 값 : " + sInput);//재사용 sInput 시켜서 출력
	    System.out.printf("사용자 입력 값 : %s\n", sInput);
   }
}
