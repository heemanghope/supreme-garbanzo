package exam01;

import java.util.Scanner;

public class Sample06 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("당신의 이름은 : ");
		String name = sc.nextLine();
		String comRps = "";
		
		int user = 0;
		int com = 0;
		int count = 0; int win =0; int draw = 0; int lose = 0;
		
		for(; ;count++) {
			com = (int)(Math.random() * 3)+1;
			if(com == 1) {
				comRps = "가위";
			}else if(com == 2) {
				comRps = "바위";
			}else if(com == 3) {
				comRps = "보";
			}
			System.out.print("가위바위보 : ");
			String userRps = sc.nextLine();
			System.out.println("컴퓨터 : " + comRps);
			System.out.print("사용자 : " + userRps);
			System.out.println();
			
		
			if(userRps.equals("가위")) {
				user = 1;
			}else if(userRps.equals("바위")) {
				user = 2;
			}else if(userRps.equals("보")) {
				user = 3;
			}else if(userRps.equals("exit")) {
				break;
			}
			else {
				System.out.println("잘못 입력하셨습니다.");
			}
		
			
			if((com == 1 && user == 2 || com ==2 && user == 3 || com == 3 && user == 1)) {
				win++;
				System.out.println("이겼습니다!");
			}else if((com ==1 && user == 1 || com ==2 && user ==2 || com ==3 || user ==3)) {
				draw++;
				System.out.println("비겼습니다.");
			}else if((com==1 && user == 3 || com ==2 && user == 1 || com ==3 && user ==2)) {
				lose++;
				System.out.println("졌습니다 ㅠㅠ ");
			}
			
		}System.out.println(count + "전 " + win + "승 " + draw + "무 " + lose + "패"  );

	}

}
