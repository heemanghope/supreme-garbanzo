package exam08;

public class Main {

	public static void main(String[] args) {
		Buyer b = new Buyer();
		  
		  b.buy(new Tv());
		  b.buy(new Computer());
		  
		  System.out.println("현재 남은 돈은 "+ b.money+"만원입니다.");
		  System.out.println("현재 남은 보너스점수는" + b.bonusPoint + "점 입니다.");

	}

}
