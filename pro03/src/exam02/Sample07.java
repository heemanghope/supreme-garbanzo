package exam02;

public class Sample07 {

	public static void main(String[] args) {
		/*
         *  중첩 반복문 
         */

		 for(int i =1; i<=3; i++) {
			 System.out.println("i가 1번 반복할 때마다.");
	            for(int j = 1; j <=3; j++) {
	            	System.out.println("j의 반복문은 3번씩 총9 번 코드의 실행이 이루어진다.");
	            }
		 
		 }
		 
		 /*
		  * 구구단
		  */
		 for(int i =1; i<=9; i++) {
			 for(int j =1; j<=9; j++) {
				 System.out.printf("%d x %d= %d\t", i,j, i*j);
			 }
			 System.out.print("\n");
		 }
		 
		 /*
		  *  다음의 결과가 나올 수 있도록 중첩 반복문을 사용하시오.
		  *  
		  *  1
		  *  2    3
  		  *  4    5    6 
  		  *  7    8    9    10
  		  *  11   12   13   14    15
  		  *  16   17   18   19    20
		  */
		 
		
		 int num =1;
		 for(int i =1; i<=6; i++) {
			 for(int j=1; j<=i; j++) {
				 System.out.print(num++ + "\t");
			 
		 }
		 
		 System.out.println("\n");
			 
		 }
		 
		 //<필드 생성자>
		//------객체 생성할 때 처음 값 지정하는 거라고 생각하기
		// \t 역슬래시 tab 쓰면 공백이 생긴다 !
	}
}