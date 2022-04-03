package exam02;

public class Sample01 {

	public static void main(String[] args) {
		System.out.print("안녕하세요");        // print 말그대로 뽑아낸것.개행 띄어쓰기 하나도 안된것. print
		System.out.print("반갑습니다");
		System.out.print("제이름은 홍길동 입니다.");	
		
		
		System.out.println("안녕하세요");        // println 띄어쓰기 충실하게 한문장씩 된것.
		System.out.println("반갑습니다");
		System.out.println("제이름은 홍길동 입니다.");	
		
		// 출력 형식을 지정하는 메서드
		int i1= 30;
		System.out.println("당신의 나이는 "+ i1 +" 세 입니다.");
		System.out.printf("당신의 나이는 %d 세 입니다.\n",i1);       //printf(특수 문자 %d,o,x,c)를 넣어둔것.
		System.out.printf("당신의 나이는 %o 세 입니다.\n",i1);  //8진수
		System.out.printf("당신의 나이는 %x 세 입니다.\n",i1);  // 16진수
		System.out.printf("당신의 나이는 %c 세 입니다.\n",i1+3); //! 아스키코드의 30에 대응되는 문자

	    double d1 =1234.5678;
	    System.out.printf("실수 표기 형식 : %f\n", d1); // 소수점 6번째까지 //f는 포맷의 약자..format의 형식..
	    System.out.printf("실수 표기 형식 : %.2f\n", d1); //소수점 2번째까지//.x가 원하는 숫자까지나오는것.
	    System.out.printf("실수 표기 형식 : %.3f\n", d1); //소수점 3번째까지
	    System.out.printf("실수 표기 형식 : %.10f\n", d1);//소수점 10번째까지
	    System.out.printf("실수 표기 형식 : %e\n", d1);
	    System.out.printf("실수 표기 형식 : %g\n", d1);
	    System.out.printf("실수 표기 형식 : %A\n", d1);
	}

}
