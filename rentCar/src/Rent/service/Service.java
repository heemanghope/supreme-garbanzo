package Rent.service;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import Rent.car.CarOrderVO;
import Rent.menu.Menu;
import member.MController;
import member.MVO;

public class Service {

	
	public Scanner sc = new Scanner(System.in);
	public MController mc = new MController();
	public Menu menu = new Menu();

	
	private CarOrderVO orders =new CarOrderVO();
	
	
	public void show() {
		
		while(true) {
			System.out.print(menu.getMenu());
			System.out.print(">>>>>>");
			String input = sc.nextLine();
			
	switch(input) {
	case "1" : 
		this.RentMenu();   break;
		
	case "2" :
		this.UserMenu();    break;
		
	case "3" : 
		System.exit(0);
		
		default : 
			System.out.println ("잘못된 번호입니다. 메뉴 번호를 다시 설정해주세요.");
	}
		
	}

}

	private void RentMenu() {
		
		MVO data = new MVO();
		
		System.out.print(" 아이디 : ");
		data.setId(sc.nextLine());
		
		System.out.print("패스워드 : ");
		data.setPwd(sc.nextLine());
		
		System.out.print("등록이름 : ");
		data.setName(sc.nextLine());
		
		System.out.print("면허번호 : ");
		data.setLnumber(sc.nextInt());
		
		System.out.print("휴대폰번호 : ");
		data.setPhonenumber(sc.nextInt());
	

	    boolean result = mc.rent(data);
	    
	    if(result) {
	    	System.out.println("회원 등록이 완료 되었습니다.");
	    	
	    } else {
	   	 System.out.println("회원등록 할 수 없습니다.(중복)");
	    }
	
    }
	
	private void UserMenu() {
		String id, pwd;
		
		System.out.println("아이디 : ");
		id = sc.nextLine();
		
		System.out.println("패스워드 : ");
		pwd = sc.nextLine();
		
		
		MVO information = mc.login(id,pwd);
		
		if(information != null) {
			System.out.println(information.getId() +"님이 로그인 하였습니다.");
			this.afterUserMenu(information);		
		}else {
			System.out.println("잘못 입력한 아이디 또는 패스워드 입니다.");
		    
		}
		
	}

	private void afterUserMenu(MVO information) {
		while(true) {
			System.out.println(menu.afterUserMenu(information.getId()));
		    System.out.print("───── ");
		    String input = sc.nextLine();
		    
		    switch (input) {
		    case"1":
		    	System.out.println("아무것도 입력을 하지 않으면 이전 값을 유지 합니다.");
		    	System.out.println("변경할 이름 : ");
		    	input = sc.nextLine();
		    	input = input.isEmpty()? information.getName() : input;
		    	information.setName(input);
		    	
		    	System.out.println("변경할 패스워드 : ");
		    	input = sc.nextLine();
		    	input = input.isEmpty()? information.getPwd() : input;
		    	information.setPwd(input);
		    	
		    	 if(mc.update(information)) {
		        	  System.out.println("정보 수정이 완료되었습니다.");
			         } else {
			    	  System.out.println("정보 수정이 실패하였습니다.");
			         }
				  break;
		    	
		    case"2":
		    	  System.out.println("패스워드 : ");
				  input = sc.nextLine();
				  
				  if(mc.remove(information, input)) {
					  System.out.println("계정 삭제 작업이 완료되었습니다.");
				      return;
			       }  else {
			    	   System.out.println("계정 삭제 작업에 실패하였습니다.");
			       }
			    	break;
		   
		    case"3" :
		    	System.out.println("예약을 시작합니다.");
		    	this.service2(orders);
				
		    	break;
		    	
		    case"4" :
		    	information = null;
		    	return;
		    default:
		    	System.out.println("잘못된 번호입니다. 다시 입력하세요.");
		    
		    }
		  }
	}

	

	private void service2(CarOrderVO order) {
		 while(true) {
			  
				System.out.println(menu.Service2(orders.getId()));
			 
				System.out.print(">>>");
			    String input = sc.nextLine();
			    
			    switch (input) {
			    case"1":
			    	
			    		System.out.println("주문을 시작합니다.");
			    		 
			    		 
			    		System.out.println("<주문>");
			    		
			    		System.out.println("대여 번호 :   ");
			    		input = sc.nextLine();
			    		System.out.println("대여하는 사용자명:   ");
			    		input = sc.nextLine();
			    		System.out.println("대여하고 싶은 차의 이름을 입력하세요\n 종류 : suv ,bmw, genesis, ferrari");
			            String CarName =sc.next();
			    		
			            
			           if(CarName == null) {
			            	System.out.println("잘못된 차 이름을 입력하셨습니다. 다시 입력하세요.");
			                     
			            }else {
			            	System.out.println("다음창으로 넘어갑니다...");
			            	
			           }	
			           
			           System.out.println("대여하고 싶은 날짜:   ");
			              String date = sc.next();
			              input = sc.nextLine();
			           //   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
			            System.out.println("대여하고 싶은 시간:   "); 
			            input = sc.nextLine();
			              
			            
			            System.out.println("대여가 완료되었습니다.");
			    	  
			    	    break;
			    	    
			    	    
			    	    
			    	    
			    case"2": 
			    	 System.out.println("주문을 출력합니다.");
			    	 this.selectOrder();
			    	 break;
					  
			    case"3": 
			    	 System.out.println("주문을 수정합니다.");	
			    	 this.modifyOrder();
			    	 break;
			  
			   
		        case"4":
		        	System.exit(0);
		    	break;
		    	
		        default:
			    	System.out.println("잘못된 번호입니다. 다시 입력하세요.");
			    
			    }
		    }
		 }

	

	

	
	private void selectOrder() {
		
			System.out.print(">>> ");
			
				 // orders.getDate();
				  
				  java.util.Date now = new java.util.Date();
				  java.sql.Date sqlDate = new java.sql.Date(now.getTime());
				  sqlDate = java.sql.Date.valueOf("2022-05-18");
			       System.out.println(sqlDate);
	}
	
	
	
	private void modifyOrder() {
		
		String input = sc.nextLine();
		
		System.out.println("아무것도 입력을 하지 않으면 이전 값을 유지 합니다.");
		  System.out.println("변경 할 아이디 : ");
		  input = sc.nextLine();
		  input = input.isEmpty() ? orders.getId() : input;
		  orders.setId(input);
		  
		  System.out.println("변경 할 이름: ");
		  input = sc.nextLine();
		  input = input.isEmpty() ? orders.getCarName() : input;
		  orders.setCarName(input);
		  
		  System.out.println("변경 할 날짜  : ");
		  input = sc.nextLine();
		  input = input.isEmpty() ?orders.getDates() : input;
		  orders.setDates(input);
		  
		  System.out.println("변경 할 시간 : ");
		  input = sc.nextLine();
		  input = input.isEmpty() ? orders.getOTime() : input;
		  orders.setOTime(input);
		 
		  System.out.println("주문정보가 수정되었습니다.");
		
	}
	
	
}


			
  	
  	




	






	

	
