package exam07;

//부장
public class Director extends DeputyGeneralManager {
	
	
	//private boolean teamManager;
	//private boolean headManager; // 본부장직 수행 여부를 구분하기 위한 멤버 변수
	
	public Director(String name, int age) {
   	 super(name, age);
   	 setSalary(8000);
	}
   	
	
	@Override
	public void bonus(int month) {
		switch(month) {
		  case 12 :
			  //super.bonus(month);
		    double bonus = getSalary() * 0.25;
		    System.out.printf("보너스 %,d 원 지급하였습니다.\n", (int)(bonus * 10000));
      }
	}
   
}