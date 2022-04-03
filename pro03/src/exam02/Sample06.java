package exam02;

import java.util.Scanner;

public class Sample06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		 * 사용자가 입력한 정수값까지 반복 출력하는 코드를 작성한다.
		 * (1~ 사용자 입력 값 까지 출력)
		 * 
		 * 
		 */
        int num;
         
         System.out.print("정수값 입력 : ");
         num =sc.nextInt();
         for(int i =0; i <num; i++) {
        	 System.out.println(i+1);
         }
         
         /*
	 * 사용자가 입력한 정수값 부터 ~1 까지 반복 출력하는 코드를 작성한다.
		 * 
		 */
	
         System.out.print("정수값 입력: ");
         num =sc.nextInt();
         for(int i=num; i>=1; i--) {
        	 System.out.println(i);
         }
		
		/*
		 * 위 문제에서 반복 출력할 때 한 줄에 7개의 정수 값이 출력되도록 코드를 작성한다.
		 * 
		 */
		
        int cnt=0; //flag   cnt가 애초에 0이다.
        
        System.out.print("정수값 입력: ");
        num =sc.nextInt();
        
        for(int i=0; i < num; i++) {
            System.out.print(i + 1+ " ");//        출력하고 
            cnt++;//                              증가시키기
            if((i+1) %7== 0) {//7까지 쓴다음에 0으로 다시 돌아가기.
            	System.out.println(); //개행을시켜줌.ln
            	
            }
	}

        
        
        
        //flag 임시로 저장했다가 나중에 추가 로직이 동작할 수 있게 만드는 것.
        //깃발의 뜻처럼 상태를 기록하고 처리 흐름을 제어하기 위한 변수.
        //처리 흐름을 제어할 때 사용해 제어 플래그(control flag)//참과 거짓을 나타내는 boolean 타입의 변수에 토글기능에 사용하기도함.
}
	
	
	
	
	
}
