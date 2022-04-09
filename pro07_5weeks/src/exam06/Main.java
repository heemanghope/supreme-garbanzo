package exam06;

import java.util.Random;

public class Main {//다형성적용하기.

	public static void main(String[] args) {
		/*
		 * - 일반 고객 5명을 생성한다.
		 * - 일반 고객 5명을 랜덤으로 선택하여 랜덤한 가격으로 물품 구입하게 한다.
		 * - 물품 (누적)구입액이 1,000,000 원을 초과하면 프리미엄 고객으로 전환을 시켜서 다음 번
		 *   물품 구입에 할인율이 적용될 수 있게 만든다.
		 * - 고객이 물품을 구입한는 작업을 반복문을 이용하여 작업한다.(반복횟수는 100번)
		 * 
		 * 일반 고객 -> 프리미엄 고객 전환
		 *     NormalCustomer n1 = new NormalCustomer("홍길동", 35, 'M');
		 *     PremiumCustomer p1 = new PremiumCustomer(n1.getName(), n1.getAge(), n1.getGender());//이름.나이.성별
		 */
		
		Random rand = new Random();
		Customer[] cArr = new Customer[5]; //객체배열
		
		cArr[0] = new PremiumCustomer("홍길동", 35, 'M');
		cArr[1] = new NormalCustomer("고길동", 35, 'M');
		cArr[2] = new PremiumCustomer("강조석", 25, 'M');
		cArr[3] = new NormalCustomer("최조한", 38, 'M');
		cArr[4] = new NormalCustomer("라주성", 29, 'M');
		
		for(int i = 0; i < 100; i++) {
			int idx = rand.nextInt(cArr.length);//10000부터 300000까지.
			cArr[idx].buy("xxxxxx", (int)(rand.nextInt(300000) + 10000) / 10000 * 10000);
			//buy 부모메서드를 활용해서 자식메서드 실행하는 것이다.                     //천의 자리부터 0을 만들기 위해서 곱하기함.
			if(cArr[idx] instanceof NormalCustomer) {
				if(cArr[idx].getPriceTotal() > 1000000) {//100만원을 넘어서면
					PremiumCustomer p = new PremiumCustomer(cArr[idx].getName(), cArr[idx].getAge(), cArr[idx].getGender());
					p.setPriceTotal(cArr[idx].getPriceTotal());//누적금액도 승계시킴.
					cArr[idx] = p;
					System.out.printf("%s님의 등급이 프리미엄 등급으로 상향되었습니다.\n", cArr[idx].getName());
					System.out.printf("현재 적용된 할인율은 %.2f 입니다.", ((PremiumCustomer) cArr[idx]).getDiscount());
				}
			}
		}
		
	}

}



//일반 고객 

//이름,나이,성별

//프리미엄 고객 
//이름 ,나이 ,성별, 할인률, 누적구입액

//프리미엄 고객의 경우 누적 구입액에 따라 할인율을 차등적으로 부여하는 기능이다.

//누적 구입액이 1,000,000
