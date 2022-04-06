package exam01;

public class Child extends Parent {//부모의 상속만 취한다. //자식이 부모의 대한 생성도 한다.-
//부모가 시키는 대로 쓴다.// 상속관계에서는 기본생성자가 필요! 반드시 필요한것은 아님.

	public Child(int number) {//생성자는 상속이 안됩니다.
	super(10);//부모생성자 명시 ******조심*******
		
//노션 메모보기.
	}
	
	//안해도 상관 없지만 오버라이딩이 가능한 메서드인지 확인하는 용도
	@Override//리턴타입, 매개변수,메서드 동일한지????? 전부다 제대로 보기!!!!!!!
  public int getNumber() {//super을 안쓰면 자식이 우선임 //부모를 우선시킬꺼면 super 명시하기
	  
		System.out.println("자식의 getNumber 메서드 시작");
		int num = super.getNumber();//부모의 getNumber로 가기
		System.out.println("자식의 getNumber 메서드 끝");
        return num +10; //오버라이드 : 부모가 가지고 있는 메서드와 동일하게 정의한다.
	  //int 반환타입 ()매개변수 , 접근제한자도 모두 동일하게 사용 :오버라이드
	  // 기존 부모의 기능을 재정의 할 수 있음.//super는 부모를 명시하는것이다. 나한테의 getnumber가 아니라, 부모가가지고 있은것 재정의하는것이다.
  }  //super 새로운 것으로 정의할것이다. 나만의 기능은 super 노노..
  //부모가 가지고 있는거에서 동작시킨다! 이러면 부모의 메서드로 만드는거면 super를 붙이기.

}
