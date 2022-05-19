package Rent.menu;

import java.util.Scanner;

public class Menu {
  


   
	
	public String getMenu() {
		String s ="<<menu>>\n 1. 정보등록 2. 로그인 3.종료";
	return s;
		
		
	}

	public String  afterUserMenu(String id) {
		String s ="<<menu>> \n 1.고객정보 수정하기 2.고객정보 삭제하기 3. 예약하기   4.종료";
	    return s;
		
	}
	
	public String Service2(String id) {
		String s ="<<menu>> \n 1.주문하기 2.출력 3.수정 4.로그아웃";
		return s;
		
	}






}
