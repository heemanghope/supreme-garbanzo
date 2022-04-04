package exam01;

import java.util.Scanner;

public class Sample08 {

	public static void main(String[] args) {
		/*
		 * 사용자가 입력한 영문자열에서 입력된 문자의 수를 구하는 코드를 작성
		 *    1. 영문자를 제외한 다른 문자는 무시한다.
		 *    2. 영문자의 대/소문자를 구분하지 않고 문자 수를 구한다.
		 * 
		 * 
		 * 예제
		 *          영문자 입력 : hello java programming
		 *          
		 *          입력한 영문 자 분포
		 *          
		 *          a(3),e(1),g(2),h(1),i(1),
		 *          j(1),l(2),m(2),n(1),o(2),
		 *          p(1),r(2),v(1)
		 *          
		 *          
		 */

  

 Scanner sc =new Scanner(System.in);

  System.out.print("영문자 입력 : ");
   String data = sc.nextLine();
   
 //알파벳 사용 횟수를 저장하기 위한 배열
   //0:a ,1:b,2:c... 25:z
   int[] cArr =new int[26]; // 0 1 2 3 4...  //알파벳 26자 안에서 카운트를 센다.
                            // A B C D E...
   
   for(int i =0; i<data.length(); i++) {//ascii
	   char c =data.charAt(i);//문자를 추출한다.
	   
	    if((c >='A' && c<= 'Z')){
	    	cArr[c -'A'] +=1; //사용자가 입력한 c에서 A만큼 뺀다. 그위치에 1씩 증가시킨다.
	    	
	    }else if((c >='a' && c <='z')) {
	        //아스키 코드 65를 0으로 치환해서 해석
	    	
	    	
	            
	    	cArr[c-'a'] +=1; //cArr[c%32-1] +=1 나머지값1A 2B 3C...
	    }                                 //1 - 1 ->0
	            // +=1; 1씩 증가시킨다.!!!
	         
	   }                                            //32의 배수로 대문자 소문자가 나누어져있다.
	                                         // 대 소 97A-65a=32
	                                             //97/32 =1     대소문자 구별을 안한다 하면 32로 나누기 .... 
	                                                        // 나머지값1 A 2 B....이런식으로...
	    
	  //  switch(c) {
	  //  case 'A' :  case'a' :
	 //   	cArr[0] += 1; break;
	  //  case 'B' :  case'b' :
	  //  	cArr[1] += 1; break;
	  //  case 'C' :  case'c' :
	  //  	cArr[2] += 1; break;
	  //  case 'D' :  case'd' :
	  //  	cArr[3] += 1; break;
	  //  case 'E' :  case'e' :
	  //  	cArr[4] += 1; break;
	    	
	 //   }
	    
	    
     
	   
    for(int i= 0; i <cArr.length; i++) {
    	if(cArr[i] >0) {
    		System.out.printf("%c(%d)\t",(char) (i+97),cArr[i]);
		   }
   }

	
	}
	
	
	
	
	
}