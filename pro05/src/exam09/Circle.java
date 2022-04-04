package exam09;

public class Circle {
//  멤버변수는 가급적 private로 설정하기             //캡슐화를 하면 멤버변수에 직접적으로 접근 할 수가 없음.
	private final static double _PI = 3.14;

	//PI가 따로 지정되어잇는게 아니라면 PRIVATE으로 가능
	
	private double radius;  
	private double area;                                   
	private double round;
	
	public Circle() {}
	
	public Circle(double radius) {
		setRadius(radius);
	}
	
	// setter
	public void setRadius(double radius) {
		this.radius = radius;
		_area();	_round();//기본값을 설정하기 위해서 area round 를 넣는다.이것을 없애면 둘레와 넓이의 값이 0.0으로 나옴.
	}//생성자
	                                         
	// getter
	public double getRadius() {
		return radius;
	}
	
	public double getDiamiter() {  //diamiter 지름
		return radius * 2;   //radius 반지름
	}
	
	// getter
	public double getArea() {
		return area;
	}
	
	// getter
	public double getRound() {
		return round;
	}
	
	private void _area() {
		area = _PI * radius * radius;            //원의 넓이 : (반지름)×(반지름)×(원주율)
	}
	//c1.setRadius(5); private의 이유!
	private void _round() {
		round = 2 * _PI * radius;                      //원의 둘레 : 지름 * 원주율
		                                                  //원의 둘레 : 반지름 * 2*원주율
	}
}
