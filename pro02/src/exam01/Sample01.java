package exam01;

public class Sample01 {

	public static void main(String[] args) {
		int i1 = 500; //int 4byte
		byte b1;//1byte
		
		b1 =(byte)i1;  // 강제 형변환  	 i1 큰거에서 b1 작은 거로 변환하기.(byte)뜻은 캐스팅이다.	
		System.out.println(i1);    //손실을 감수하고 형변환을 시키는 것이다.
		System.out.println(b1);
		
		byte b2 =100;
		int i2;
		
		i2 =b2; // 자동 형변환 -작은 것을 크게 만든다.
		
		double d1 =10.4;
		int i3 = 5;
		int i4;
		
		i4 =(int)(i3+ d1); // 자동 형변환, 강제 형변환
		
		double d2 = 10.6;
		double d3 = 10.7;
		int i5,i6;
		
		i5 =(int)(d2+d3); //10.6 +10.7 =21.3 이므로 21로 만들어짐.
		i6 =(int) d2 + (int)d3; //정수값으로 미리 만들어놓고 10 +10 =20으로 됨.
		
		System.out.println(i5);
		System.out.println(i6);
	
		//강제형변환 ,자동형변환 이외의 예외 변수들
		int i7 =0;
		//boolean b3= (boolean)i7;       //boolean 형의 캐스팅은 안됨.
		
		String s2 ="100";
		//i7 =(int)s2;     // 문자열"String"을(정수) "int" 기본자료형으로 변환(캐스팅) 안됨.
		
		s2 = i7+""; // 캐스팅은 아니지만 기본타입을 문자열로 변환 할 수 있다.
		
		
		
	}

}
