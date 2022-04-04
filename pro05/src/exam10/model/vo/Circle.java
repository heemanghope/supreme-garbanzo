package exam10.model.vo;

public class Circle {

	private final double PI = 3.14;  //PI 대문자 =상수다 -final 붙여주기
	private int radius = 1;
                                                             
	public void incrementRadius() {                           
		//반지름의 크기를 1 증가시키는 메서드                         
		radius++;
		
	}
	
	public void getAreaofCircle() {
		//원의 넓이를 구해서 출력하는 메서드
		double area = PI * radius * radius;
		System.out.println(area);
	}
	
	public void getSizeOfCircle() {
		//원의 둘레를 구해서 출력하는 메서드
		double size = 2* PI *radius;
		System.out.println(size);
	}
	
	
	
	
}
