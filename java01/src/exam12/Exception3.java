package exam12;

public class Exception3 {
 public static void main(String args[]) {
//method1()은 static 메서드이므로 인스턴스 생성없이 직접 호출이 가능하다.
  Exception3.method();
  System.out.println("method()의 수행을 마치고 main메서드로 돌아왔습니다.");
 }

private static void method() {
	
	try {
	    System.out.println("method()이 호출되었습니다.");
	    return;//현재 실행중인 메서드를 종료한다.//return문을 만나도 finally까지 입력된후에 다시 main으로 돌아간다.
	}	catch (Exception e) {
		e.printStackTrace();
	}  finally {
		System.out.println("method()의 finally블럭이 실행되었습니다.");
	}
	
}
}
