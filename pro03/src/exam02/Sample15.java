package exam02;

import java.util.Scanner;
import java.util.Random;

public class Sample15 {

	public static void main (String [] args) {
	    Scanner sc =new Scanner(System.in);
	    Random rd =new Random();
	    String name = "" , player ="", sCom ="";
		int computer = 0; 
		int result = 0;
	    int wCnt = 0, dCnt = 0, lCnt =0;  //승패 기록을 남겨놓음
	    
		
		
		System.out.print("당신의 이름을 입력하세요. : " );
		name = sc.nextLine();
	
		
		
		
	 for(;;) {
		System.out.print("가위 바위 보 입력 : ");
		player =sc.nextLine();
		computer = rd.nextInt(3);  // 0(가위), 1(바위) ,2(보)
		
		if(computer ==0) {//컴퓨터
			sCom = "가위"; //비김
			
		} else if (computer ==1) {
			sCom = "바위"; //사용자 짐
		} else if (computer ==2) {
			sCom = "보"; //이겼습니다.
		}
		
		//player 기준
		
		if(player.equals("exit")) {//equals 비교
		 System.out.printf( "%d전 %d승 %d무 %d패\n", wCnt +dCnt + lCnt, wCnt,dCnt, lCnt );
				break;
		

	    } else if (player.equals("가위") || player.equals("바위") || player.equals("보")) {
	     System.out.println("컴퓨터 : " + sCom);
	     System.out.println(name + " : " + player);
	     
	     result =0;
	     if(player.equals("가위")) {
	    	if(computer == 1) {
	    		result =-1;//짐
	    	
	    	} else if (computer == 2) {
	    		result =1;	//이김
	    			
	    		}
	        } else if (player.equals("바위")) {
	    	if(computer == 0) {
	    		result =1;//이김
	    	} else if (computer == 2) {
	    		result =-1;	//짐
	    			
	    		}
	    	
	    } else if (player.equals("보")) {
	    	if(computer == 0) {
	    		result =-1;//짐
	    	} else if (computer == 1) {
	    		result =1;	//이김
	    			
	    		}

	    }
	     
	     
	     
	  switch(result) {//졌는지 비겼는지 이겼는지 
	       case -1 :
	    	   System.out.println("졌습니다.");
	    	   lCnt++; break;
	       case 0 : 
	    	   System.out.println("비겼습니다");
	    	   dCnt++; break; //draw
	       case 1 : 
	    	   System.out.println("이겼습니다");
	    	   wCnt++;//마지막문장이므로 break 생략 
	          }
	
	    } else {
	    	System.out.println("잘못 입력했습니다. 다시 입력하세요.");
	    	
	}
		
		
		
		}
		
    }
  }
	
