package exam11;

class A{
//	public void method(B b)
	public void method(I i) {// 인터페이스 I를 구현한 넘들만 들어와라
		i.method();
	}
}//A를 안바꾸는게 목표

interface I {
	public void method();//메서드의 선언
}

class B implements I{
	public void method() {
		System.out.println("B 클래스의 메서드");//메서드의 구현을 분리함.
		
	}
}
class C implements I{
	public void method() {
		System.out.println("C 클래스의 메서드");
		
	}
}

public class InterfaceTest {
    
	public static void main(String[] args) {
		A a = new A();
		a.method(new B()); //A가 B를 의존하고 있다.

	}

}
