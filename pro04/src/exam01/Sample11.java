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
		
		int[] arr1 =new int[0];  // 동적배열을 사용할것임으로 크기를 0으로 설정한다.
		
		int i =0;
		for(;;) {
			System.out.printf("%d 번째 정수값 입력 : ", i + 1); //반복회수를 가지고 알아냈는데 i값으로 알수 없으므로,
			                                                  //i=0이라는 값을 별도로 만들어놓는다.
			
			int num;
			String other =""; // 그외에는 string에 저장하라
			if(sc.hasNextInt()) {  //정수
     //사용자입력을받음
				num =sc.nextInt(); sc.nextLine(); 
				//버퍼의 남아있는 데이터를 클리어시켜준다. 버퍼//개행이 남아있다. nextInt에.. 
                //클리어 플러쉬 ->> 스캐너로,, (엔터키) 개행을 날려버리기위해서 (2)번 ! 겹쳐져있으면 넥스트 라인을 쓴다.
                 
			}else {
				other = sc.nextLine();//두번입력되었다고 알아들음
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
			
			int[] temp = Arrays.copyOf(arr1, arr1.length + 1);  //arr1을 arr1만큼 복사한다
			arr1=temp; //참조값을 저장시킨다.
			
			arr1[i] =num; //사용자가 지정한 i에다가 num을 지정한다.
			tot +=arr1[i]; //tot arr1을 계속해서 누적한다.
			i++;
		 
	  }
	
     avg =(double)tot /arr1.length;
	 System.out.printf("총 합  : %d\n " ,tot);
	 System.out.printf("평 균 : %.1f" , avg);
	
		
		
	}

	
	
	
}
