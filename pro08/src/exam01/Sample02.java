package exam01;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Sample02 {
     Scanner sc =new Scanner(System.in);
	
	
	public void ex01() {
		/*
		 * 정수값 입력을 받을 때 한번의 입력으로 1개 이상의 정수값.
		 * 받을 수 있게 한다.(nextLine() 메서드를 사용해야한다.)
		 * 
		 * 예시. 정수값 입력 : 10 20 30 40 50
		 * 
		 *    다음의 값을 입력하였습니다.
		 *    10 20 30 40 50
		 * 
		 */
           
		
		Scanner sc =new Scanner(System.in);
		
		System.out.print("정수값 입력 : ");
		String input = sc.nextLine();
		
		//wrapper, StringTokenizer 활용하여 정수배열에 저장
		//String[] sArr = input.split(" ");
		StringTokenizer token = new StringTokenizer(input," ");
		int iArr[] = new int[token.countTokens()];
		int idx=0;
		while(token.hasMoreTokens()) {
			iArr[idx++] = Integer.parseInt(token.nextToken());
		}
		
		
		System.out.println("다음의 값을 입력하였습니다.");
		System.out.println(Arrays.toString(iArr));
		
      }   
	
	
	
	public static void main(String[] args) {
		Sample02 s2 = new Sample02();
	s2.ex01();
		// s2.ex02();
		// s2.ex03();
		 //s2.ex04();
	}

	


	public void ex02() {
		/*
		 * 사용자 입력으로 전화번호를 입력 받을 때 xxx-xxxx-xxxx 형식으로 입력하지 않은 경우
		 * 다시 입력하도록 한다.//반복문 필요
		 */
		while(true) {
			System.out.print("전화번호 입력 : ");
            String input =sc.nextLine();
			String[] sArr = input.split("-");
			
			if(sArr.length != 3) {//하이픈의 기준으로 3개
			  continue;//다시 입력하겠다.
			}
			
			if(!(sArr[0].length() ==3 && sArr[1].length() ==4 && sArr[2].length()==4)) {
                 continue;				
			
			}
			
			System.out.println("전화번호를 입력하였습니다.");
			break;
		}
	}	
	
	
	
	
	
	public void ex03() {
		/*
		 * 사용자 입력으로 전화번호를 입력 받고 출력할 때 전화번호 마지막 4자리 숫자는
		 * 다음의 문자로 마스킹 처리하여 출력되도록 한다. (마스킹 문자 -> *)
		 */
		System.out.print("전화번호 입력:  " );
		String input = sc.nextLine();
		String[] sArr = input.split("-");
		sArr[2] = "****";
		String masking = String.join("-", sArr);
		System.out.println(masking);
		
	}
	
	
	
       
	
	
	public void ex04() {
		/*
		 * 사용자 입력으로 이메일 주소 형식을 입력 받을 때 xxxxx@gmail.com 또는 xxxxx@naver.com,
		 * xxxxx@nate.com 의 주소 형식만 받을 수 있도록 한다.(xxxxx 는 5글자 제한 아님)
		 */
		String[] emailDomain = new String[] {
				"gmail.com", "naver.com", "nate.com"
		};
		
		while(true) {
			System.out.print("이메일 주소 입력 : ");
			String input = sc.nextLine();
			
			String[] sArr = input.split("@");
			
			if(sArr.length != 2) {
				System.out.println("이메일 주소 형식이 아닙니다. 다시 입력하세요.");
				continue;
			}
			
			boolean valiad = false;
			for(int i = 0; i < emailDomain.length; i++) {
				if(sArr[1].equals(emailDomain[i])) {
					valiad = true;
				}
			}
			
			if(!valiad) {
				System.out.println("허용된 이메일 주소가 아닙니다. 다시 입력하세요.");
				continue;
			}
			System.out.println("이메일 주소를 확인하였습니다.");
			break;
		}
	}

	
}

	
	
	

