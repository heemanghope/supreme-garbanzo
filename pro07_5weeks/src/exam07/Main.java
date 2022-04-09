package exam07;
//상속과 오버라이딩을 활용한 함수들.



/*
 * 사원 2800
대리  3000                                              다형성이라는 것 상위객체 - 하위객체.
과장 4000
차장 5500                                                 과장+팀장
부장 8000                                                         기본 연봉 4000 + 팀장 수행 추가(4000 *0.1=400)
                                                                     과장=4400

 과장 이상부터는 팀장직책
 차장이상부터는 본부장 직책                                                                 +
                                                                    4개월에 1번 보너스(4000 * 0.25 * 3 =3000)
팀장 직책을 수행하는 경우 연봉의 10% 보너스                                                  = 7400
본부장 직책 수행 연봉의 20% 보너스

모든 직원들은 1달에 1번 급여
직위마다 받는 시점이 다르다. 급여와 보너스
보너스는 연봉의 25%
사원 대리는 6개월의 한번
과장 차장은 4개월의 한번
부장은 1년에 1번

대리이상의 직원 법인 카드 가능
단, 법인 카드 사용액은  연봉의 1.5% 초과불가

반복문의 1회 반복시마다 1달 시간이 흐르는 것으로 간주.
법인 카드 사용은 이벤트성으로 1~9사이에의 랜던 값 중에 4의 배수 값 발생
대리 ,과장, 차장 ,부장 한명.

 */
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rand =new Random();
		
		Employee e1 = new Staff("김사원", 28);
		Employee e2 = new AssistantManager("박대리", 32);
		Employee e3 = new DepartmentManager("이과장", 38);
		Employee e4 = new DeputyGeneralManager("차차장", 43);
		Employee e5 = new Director("곽부장", 48);
		
		Employee[] empArr = new Employee[5];
		empArr[0] = e1;	empArr[1] = e2;	empArr[2] = e3;
		empArr[3] = e4;	empArr[4] = e5;
		
		((DepartmentManager)e3).setTeamManager(true);//보너스
		((DeputyGeneralManager)e4).setHeadManager(true);
		((Director)e5).setHeadManager(true);
		
		
		
		for(int m =1; m <=30; m++) {
			int month =m%12 == 0 ? 12 : m% 12;   //나머지 연산 활용.
			System.out.printf("%d 월 급여 지급 내역\n",month);
			System.out.println("------------------------------------");
		    for(int i = 0; i < empArr.length; i++) {			
                empArr[i].payMonth();
                empArr[i].bonus(month);         
                
                if(empArr[i] instanceof TeamManager) {//인터페이스를 적용해서 형변환시키기.
                	((TeamManager)empArr[i]).teamPayBonus(); 	
                }
                if(empArr[i] instanceof HeadManager) {
                	((HeadManager)empArr[i]).headPayBonus(); 	
                }
               
            	System.out.println("-------------------------------");
			}
			
			if((rand.nextInt(9) + 1) % 4 == 0) {
				int idx = rand.nextInt(4) + 1;//누가 지불했는지 알아야한다.
				System.out.println(empArr[idx].getName() + "가(이) 법카 쏜다~");
				((AssistantManager)empArr[idx]).corpCard(100000);
			}
			
			System.out.println("===============================");
		}
	}

}
