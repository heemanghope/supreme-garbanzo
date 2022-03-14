package exam01;

import java.util.Scanner;

public class Sample05 {

	public static void main(String[] args) {
		/*
		 * 사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요.
컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고, 사용자에게는 직접 가위바위보를 받으세요
사용자가 "exit"를 입력하기 전까지 가위보를 계속 진행하고 "exit"가 들어가면 반복을 멈추고
몇번의 승부에서 몇번 이기고 몇번비기고 몇번 졌는지 출력하세요.
        * (예시) : 
        * 당신의 이름을 입력해 주세요: 박희망
        * 가위바위보 : 가위
        * 컴퓨터 : 가위
        * 박희망: 가위
        * 가위바위보 : exit
        * 8전 2승 4무 2패
        * 

		 */

		Scanner sc = new Scanner(System.in);
		
		System.out.print("당신의 이름을 입력해주세요 : ");
		String name = sc.nextLine();
		
		
		int count = 0; // n전
		int win = 0; // n승
		int draw = 0; // n무 // n전 - n승 - n무 = n패
		
		
		String winStr = "이겼습니다 !";
		String loseStr = "졌습니다 ㅠㅠ";
		
		
		while (true) {
			int comInt = (int) (Math.random() * 3); // 0, 1, 2
			String comStr = null;
			switch (comInt) {
			case 0:
				comStr = "가위";
				break;
			case 1:
				comStr = "바위";
				break;
			case 2:
				comStr = "보";
				break;
			}
		
		
		
		System.out.print("가위바위보 : ");
		String userStr = sc.nextLine();

		String result = null;

	
		
		if (userStr.equals("가위") || userStr.equals("바위") || userStr.equals("보")) {
			if (comStr.equals(userStr)) {
				result = "비겼습니다.";
				draw++;
			} else {
				if (comStr.equals("가위")) {
					switch (userStr) {
					case "바위":
						result = winStr;
						win++;
						break;
					case "보":
						result = loseStr;
						break;
					}
				} else if (comStr.equals("바위")) {
					if (userStr.equals("보")) {
						result = winStr;
						win++;
					} else {
						result = loseStr;
					}
				} else {
					result = userStr.equals("가위") ? winStr : loseStr;
					if (result.equals(winStr)) {
						win++;
					}
				}

			}
			
		}else if(!userStr.equals("exit")) {
			System.out.println("잘못 입력하셨습니다. ");;
			continue;
		}else {
			break;
		}
		count++;
		System.out.println("컴퓨터 : " + comStr);
		System.out.println(name +  " : " + userStr);
        System.out.println(result);
	}
	System.out.printf("%wjs, %승 % d패 d패", count, win, draw, (count-win-draw));
	

	}
}
		

