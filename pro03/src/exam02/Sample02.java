package exam02;

public class Sample02 {

	public static void main(String[] args) {
		// 1~99 까지 반복문을 사용하여 반복 출력 하시오.(단, 초기값 설정은 i =1 로 한다.)
		for(int i=1;  i<100; i++ ) {
			System.out.println(i);
		// 1~99 까지 반복문을 사용하여 반복 출력 하시오.(단, 초기값 설정은 i =0 로 한다.)
		
		}		
			
			System.out.println("----------");
			for(int i =0;  i < 99; i++) { 
				System.out.println(i + 1);  //98+1 =99까지로 나오게 만들기.
			}
		//1 ~99 까지 반복문을 사용하여 반복 출력 하시오.(단, 짝수에 해당하는 값만 출력 하시오.)

	
			System.out.println("----------");
			for(int i=2;  i<100; i+=2 ) { //초기식 2로 시작해서 100전까지
				//2씩 증가합니다.
				System.out.println(i);
			}
	}
	}
