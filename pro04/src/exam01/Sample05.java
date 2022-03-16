package exam01;

import java.util.Scanner;

public class Sample05 {

	public static void main(String[] args) {
		/*
		 *  카이사르 암호 만들기.
		 *         -사용자 입력으로 영단어를 입력 받는다.
		 *         -입력 받은 영단어는 문자 배열로 생성한다.
		 *         -생성된 문자 배열에 대해 암호화된 배열을 저장하기 위한 배열을 새로 만든다.
		 *         -문자쉬프트는 3으로 하고 만약 'z' 문자에 대한 쉬프트가 필요한 경우 'a'로 넘어가게 해야 한다.
		 *         
		 *  출력 형식       
		 *        암호화 전 : apple
		 *        암호화 후 : dssoh 
		 *      //  문자열을 문자 배열로 바꾸기 ..한번에 바꿀 필요 없음...
		 *      //  문자 배열 만든 상태에서 문자열의 문자를 저장..???? 
		 */

		
	Scanner sc =new Scanner(System.in);
	
	System.out.print("영단어 입력 :");
	String sInput = sc.nextLine();
	
	
	//문자열을 문자 배열로 변환
	char[] origin =sInput.toCharArray();
	//char[] origin =new char[sInput.length()];
	//for (int i=0; i <sInput.length(); i++) {
		// origin[i] =sInput.charAt(i);
	//}
	
	char[] crypto =new char[origin.length];
	for(int i=0; i<origin.length; i++) {       // 문자열의 길이는 [sInput.length()];<=()소괄호사용, 메서드!!
		                                      // 배열 길이/크기를 구하는<= 소괄호 사용x, 속성!! 
		if(origin[i] + 3 >'z') {
		   crypto[i] =(char)(origin[i] +3 -26);  //3을 넘으면 26원래 알파벳으로 돌아가게 한다.
		} else {
			crypto[i] =(char) (origin[i] +3);
			
		}
		
	}
	
	String res1= new String(origin);
	
	String res2= new String(crypto);
		
    //for(int i =0; i< sInput.length(); i++) {
    	//res1 += origin[i];
    	//res2 += crypto[i];
	
        //}
    
    System.out.println("암호화 전: "  + res1);
    System.out.println("암호화 후 : " + res2);
    
	}

}