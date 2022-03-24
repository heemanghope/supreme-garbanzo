package exam09;

public class Circle {

	private final static double _PI = 3.14;
	private double radius;  //멤버변수는 가급적 private로 설정하기
	private double area;                                   //캡슐화를 하면 멤버변수에 직접적으로 접근 할 수가 없음.
	private double round;
	
	public Circle() {}
	
	public Circle(double radius) {
		setRadius(radius);
	}
	
	// setter
	public void setRadius(double radius) {
		this.radius = radius;
		_area();	_round();
	}
	                                         //캡슐화라는 작업을 할때에는 항상 setter 와 getter가 필요하다.
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
	
	private void _round() {
		round = 2 * _PI * radius;                      //원의 둘레 : 지름 * 원주율
		                                                  //원의 둘레 : 반지름 * 2*원주율
	}
}
