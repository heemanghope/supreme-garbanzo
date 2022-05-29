package exam12;

public class exception1 {

	public static void main (String[] args) throws Exception {
		method1();
	//	throw new RuntimeException();// RuntimeException 을 고의로 발생시킨다.

	 }
	
// 이전과 달리 성공적으로 컴파일은 된다. 그러나 비정상적인 종료가 발생한다.
//예외 발생 throw와 예외를 method에 선언할때쓰이는 throws를 잘 구분해야한다.

static void method1() throws Exception {
	//메서드의 내용
	method2();
}     
static void method2() throws Exception {
	//메서드의 내용
	throw new Exception();
}     
}
	