package exam07;

public class Sample03 {

	public static void main(String[] args) {
		/*
		 * 같은 패키지에 다음의 클래스를 만들어 본다.
		 * 
		 * 도서 대여 프로그램에 사용할 도서 정보 클래스를 추상화하여 만드시오.
		 * 가급적 다양한 생성자를 만들어 도서 정보를 초기화 한다.
		 * (모든 멤버 변수에 대해 생성자를 만들 필요가 없음.)            // 필수 초기화 옵션 
		 */
		
		RentBook rb1= new RentBook();
		RentBook rb2= new RentBook("도서명","B333451123");
		RentBook rb3= new RentBook("도서명","3450203234","2022-03-18");
		
	}
//멤버변수 초기화 및 생성자
}
