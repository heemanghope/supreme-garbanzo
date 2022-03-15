package exam01;

import java.util.Arrays;
import java.util.Scanner;
public class Sample11 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력을 받아서 다음의 기능을 수행하는 코드를 작성 
		 *   
		 *    1. 입력한 횟수 만큼 정수 값을 입력 받아서 배열에 저장한다.
		 *    2.배열에 저장된 모든 정수의 합과 평균을 구하여 출력
		 *    3. -1 입력이 들어오면 더 이상 사용자 입력을 받지 않는 것으로 간주 한다.
		 *    
		 *       예제       
		 *       1번째 정수값 입력 :7
		 *       2번째 정수값 입력 :12
		 *       3번째 정수값 입력 :24
		 *       4번째 정수값 입력 : -1
		 *       
		 *       
		 *       총 합 : 43
		 *       평 균 : 14.3
		 *       
		 */
		
		Scanner sc =new Scanner(System.in);
		int tot=0;
		double avg;
		
		int[] arr1 =new int[0];
		
		int i =0;
		for(;;) {
			System.out.printf("%d 번째 정수값 입력 : ", i + 1);
			
			int num;
			String other ="";
			if(sc.hasNextInt()) {  //정수
                 num =sc.nextInt(); sc.nextLine(); //버퍼의 남아있는 데이터를 클리어시켜준다. 버퍼//개행 
                 //클리어 플러쉬 ->> 스캐너로,, 개행을 날려버리기위해서 (2)번 ! 겹쳐져있으면 넥스트 라인을 쓴다.
                 
			}else {
				other = sc.nextLine();
				if(other.equals("exit")) {
					break;
				}else {
					 System.out.println("정수 값 또는 exit 를 입력하세요.");
					 continue;//반복의 처음 위치로 돌아가게 한다. for(;;)으로...
					 
					 
				}
				
			}
			if(num ==-1) {
				break;
			}
			
			int[] temp = Arrays.copyOf(arr1, arr1.length + 1);
			arr1=temp;
			
			arr1[i] =num;
			tot +=arr1[i];
			i++;
		 
	  }
	
     avg =(double)tot /arr1.length;
	 System.out.printf("총 합  : %d\n " ,tot);
	 System.out.printf("평 균 : %.1f" , avg);
	
		
		
	}

	
	
	
}
