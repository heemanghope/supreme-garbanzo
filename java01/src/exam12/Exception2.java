package exam12;

public class Exception2 {
 
	public static void main(String[]args ) {
		method1();
	}
	static void method1() {
		try {
			throw new Exception();
			
		} catch(Exception e) {
			System.out.println("method1메서드가 예외가 처리되었습니다.");
		    e.printStackTrace();//예외는 처리되었으나 printStackTrace()를 통해서 예외에 대한 정보를 화면에 출력
		    
	}
   }
  }